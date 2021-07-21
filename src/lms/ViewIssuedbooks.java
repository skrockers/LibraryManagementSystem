/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sai
 */
public class ViewIssuedbooks extends javax.swing.JFrame {
Color pink=new Color(255,51,255);
Color blue=new Color(51,153,255);
Cursor hand=new Cursor(Cursor.HAND_CURSOR);


    /**
     * Creates new form ViewIssuedbooks
     */
    public ViewIssuedbooks() {
        initComponents();
    }
    public void ViewIssuedbooks()
    {
         try
    {
        //default login
        String default_name="root";
        String default_password="12345";
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,default_name,default_password);
        String view_query="select LMSNo,Student_Name,RegNo,Department,BookID,BookName,Author,Type,Regulations,Publications,IssueDate,ReturnDate,Student_MobNo from issuebooks";
        PreparedStatement ps=conn.prepareStatement(view_query);
        ResultSet rs=ps.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
        ps.close();
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error found in viewissuebooks:"+e);
    }
    }
    public void Delete()
    {
        try
    {
        //required Attributes
       int ReturnBookId=Integer.parseInt(jTextField2.getText());
        //default login
        String default_name="root";
        String default_password="12345";
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,default_name,default_password);
        String query1="delete from issuebooks where BookID=?";
        PreparedStatement ps=con.prepareStatement(query1);
        ps.setInt(1,ReturnBookId);
        int count=ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Record Deleted from IssueList");
        ViewIssuedbooks();
        //-----------------------------------------------------------------------------------------------------------------//
        con.close();
        ps.close();
    }
        catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error found in delete:"+e);
    }
    }
public void Returnbooks()
{
    try
    {
        //required Attributes
        int ReturnBookId=Integer.parseInt(jTextField2.getText());
        //default login
        String default_name="root";
        String default_password="12345";
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,default_name,default_password);  
        String query1="insert into returnbooks select LMSNo,Student_Name,RegNo,Department,BookID,BookName,Author,Type,Regulations,Publications,IssueDate,ReturnDate,Student_MobNo ,ActualReturnDate from issuebooks where BookID=?";
        PreparedStatement ps=con.prepareStatement(query1);
        ps.setInt(1,ReturnBookId);
        int count=ps.executeUpdate();
         
        
        JOptionPane.showMessageDialog(null,"Record moved to ReturnList");
        //-----------------------------------------------------------------------------------------------------------------//
        con.close();
        ps.close();
    }
    
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error found in returnbooks:"+e);
    }
    Delete();
}
public void Actual()
{
   try
    {
        Date d=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    String s=sdf.format(d);
    System.out.println(s);
    
        //required Attributes
       int ReturnBookId=Integer.parseInt(jTextField2.getText());
        //default login
        String default_name="root";
        String default_password="12345";
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,default_name,default_password);  
        String query1="update returnbooks set ActualReturnDate=curdate() where BookID=?";
        PreparedStatement ps=con.prepareStatement(query1);
       ps.setInt(1,ReturnBookId);
        int count=ps.executeUpdate();
        //-----------------------------------------------------------------------------------------------------------------//
        con.close();
        ps.close();
    }
    
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error found in returnbooks:"+e);
    }  
}
public void ViewReturnbooks()
{
     try
    {
        //default login
        String default_name="root";
        String default_password="12345";
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,default_name,default_password);
        String view_query="select *from returnbooks";
        PreparedStatement ps=conn.prepareStatement(view_query);
        ResultSet rs=ps.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
        ps.close();
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error found in viewreturnbooks:"+e);
    }
}

public  void time()
{

    new Timer(0,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date d=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
    jLabel5.setText(sdf.format(d));
        }
    }).start();
   
}
public void date()
{
    Date d=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    jLabel4.setText(sdf.format(d));
    
}
public void isearchbook()
{
    try
    {
        //default login
        String default_name="root";
        String default_password="12345";
        String  search=jTextField2.getText();
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,default_name,default_password);
        String search_query="select * from issuebooks where BookID=?";
        PreparedStatement ps=conn.prepareStatement(search_query);
        ps.setString(1,search);
        ResultSet rs=ps.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        if(search.isEmpty())
        {
            //SView();
        }
        conn.close();
        ps.close();
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
}
public void rsearchbook()
{
    try
    {
        //default login
        String default_name="root";
        String default_password="12345";
        String  search=jTextField3.getText();
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,default_name,default_password);
        String search_query="select * from returnbooks where BookID=?";
        PreparedStatement ps=conn.prepareStatement(search_query);
        ps.setString(1,search);
        ResultSet rs=ps.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        if(search.isEmpty())
        {
           ViewReturnbooks();
        }
        conn.close();
        ps.close();
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
}





/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("IssuedBooks List");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 100, 180, 40);

        jTable1.setBackground(new java.awt.Color(255, 102, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 180, 1340, 240);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Return");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 400, 63, 22);

        jButton1.setBackground(new java.awt.Color(255, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("RETURN");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(830, 460, 100, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setText("RETURN BOOK LIST");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 440, 179, 22);

        jTable2.setBackground(new java.awt.Color(255, 102, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 530, 1340, 230);

        jButton2.setBackground(new java.awt.Color(255, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("BLACKLIST");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1230, 460, 104, 35);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 255));
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(790, 130, 180, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 255));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(970, 130, 180, 40);

        jTextField2.setBackground(new java.awt.Color(255, 102, 255));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(102, 102, 102));
        jTextField2.setText("Enter BookID");
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField2.setName(""); // NOI18N
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(80, 140, 303, 30);

        jButton3.setBackground(new java.awt.Color(255, 102, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("SEARCH");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(400, 140, 90, 30);

        jButton4.setBackground(new java.awt.Color(255, 102, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(500, 140, 80, 29);

        jTextField3.setBackground(new java.awt.Color(255, 102, 255));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(102, 102, 102));
        jTextField3.setText("Enter BookID");
        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(70, 470, 289, 34);

        jButton5.setBackground(new java.awt.Color(255, 102, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("SEARCH");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(380, 470, 90, 34);

        jButton6.setBackground(new java.awt.Color(255, 102, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("CLEAR");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(480, 470, 80, 34);

        jButton7.setBackground(new java.awt.Color(255, 102, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("BACK");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(1190, 80, 80, 30);

        jButton8.setBackground(new java.awt.Color(255, 51, 255));
        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sai\\Downloads\\iconfinder_button_close_352915 (1).png")); // NOI18N
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(1320, 0, 40, 30);

        jButton9.setBackground(new java.awt.Color(255, 102, 255));
        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sai\\Downloads\\iconfinder_minus_1303882.png")); // NOI18N
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(1280, 0, 40, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/Untitled design (4).png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 2420, 770);

        setSize(new java.awt.Dimension(1367, 770));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Returnbooks();
        Actual();
        ViewReturnbooks();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Blacklist bl=new Blacklist();
        bl.setVisible(true);
        dispose();
        bl.viewblacklist();
        bl.date();
        bl.time();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        isearchbook();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         jTextField2.setText("Enter BookID");
         ViewIssuedbooks();
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        rsearchbook();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         jTextField3.setText("Enter BookID");
         ViewReturnbooks();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        LMenupage lm=new LMenupage();
        lm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        // TODO add your handling code here:
        jButton8.setBackground(Color.red);
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        // TODO add your handling code here:
        jButton8.setBackground(pink);
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
        jButton9.setBackground(Color.GRAY);
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
        jButton9.setBackground(pink);
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(LibrarianLogin.ICONIFIED);
        //102,102,255
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        jButton7.setCursor(hand);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setCursor(hand);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setCursor(hand);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setCursor(hand);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setCursor(hand);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setCursor(hand);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jButton5.setCursor(hand);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
        if(jTextField2.getText().equals("Enter BookID"))
        {
            jTextField2.setText("");
        }
        jTextField2.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
         if(jTextField2.getText().equals(""))
        {
            jTextField2.setText("Enter BookID");
        }
        jTextField2.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        // TODO add your handling code here:
        if(jTextField3.getText().equals("Enter BookID"))
        {
            jTextField3.setText("");
        }
        jTextField3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        // TODO add your handling code here:
          if(jTextField3.getText().equals(""))
        {
            jTextField3.setText("Enter BookID");
        }
        jTextField3.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_jTextField3FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewIssuedbooks().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
