/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Sai
 */
public class Issuebooks extends javax.swing.JFrame {
Color pink=new Color(255,51,255);
Color blue=new Color(51,153,255);
Cursor hand=new Cursor(Cursor.HAND_CURSOR);
    /**
     * Creates new form Issuebooks
     */
    java.util.Date idate;
    java.sql.Date isqldate;
    java.util.Date rdate;
    java.sql.Date rsqldate;
    public Issuebooks() {
        initComponents();
    }
    public void bookauto()
    {
        try
        {
            int Bookid=Integer.parseInt(jTextField6.getText());
            String default_name="root";
                    String default_password="12345";
                    String url="jdbc:mysql://localhost:3306/lms";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,default_name,default_password);
            String query="select Name,Author,Type,Publications,Regulations from addbooks where BookID="+Bookid;
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    
                    while(rs.next())
                    {
                      jTextField7.setText(rs.getString("Name"));
                      jTextField8.setText(rs.getString("Author"));
                      jComboBox1.setSelectedItem(rs.getString("Type"));
                       jComboBox2.setSelectedItem(rs.getString("Regulations"));
                      jTextField9.setText(rs.getString("Publications"));
                      
                    }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void studentauto()
    {
        try
        {
            int LMSid=Integer.parseInt(jTextField1.getText());
            String default_name="root";
                    String default_password="12345";
                    String url="jdbc:mysql://localhost:3306/lms";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,default_name,default_password);
            String query="select Name,RegNo,Department,ContactNo from sregister where LMSNo="+LMSid;
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    
                    while(rs.next())
                    {
                      jTextField2.setText(rs.getString("Name"));
                      jTextField3.setText(rs.getString("RegNo"));
                       jComboBox3.setSelectedItem(rs.getString("Department"));
                      jTextField5.setText(rs.getString("ContactNo"));
                      
                    }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void Issuebooks()
    {
        try
        {
              
            String BName=jTextField7.getText();
            String Author=jTextField8.getText();
            String Type=jComboBox1.getSelectedItem().toString();
              String Publications=jTextField9.getText();
            //required attributes
            //----------------------------------------------------------------------
            int LMSNo=Integer.parseInt(jTextField1.getText());
            String SName=jTextField2.getText();
            long RegNo=Long.parseLong(jTextField3.getText());
            String Dept=jComboBox3.getSelectedItem().toString();
            int BookID=Integer.parseInt(jTextField6.getText());
            int Regulations=Integer.parseInt(jComboBox2.getSelectedItem().toString());
            SimpleDateFormat sdf=new SimpleDateFormat("dd--MM-yyyy");
            idate=jDateChooser1.getDate();
            isqldate=new java.sql.Date(idate.getTime());
            rdate=jDateChooser2.getDate();
            rsqldate=new java.sql.Date(rdate.getTime());
            long SMobNo=Long.parseLong(jTextField5.getText());
            //-----------------------------------------------------------------------
                    String default_name="root";
                    String default_password="12345";
                    String url="jdbc:mysql://localhost:3306/lms";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,default_name,default_password);
                    String add_query="insert into issuebooks values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps=con.prepareStatement(add_query);
                    ps.setInt(1,LMSNo);
                    ps.setString(2,SName);
                    ps.setLong(3,RegNo);
                    ps.setString(4,Dept);
                    ps.setInt(5,BookID);
                    ps.setString(6,BName);
                    ps.setString(7,Author);
                    ps.setString(8,Type);
                    ps.setInt(9,Regulations);
                    ps.setString(10,Publications);// need to increase length in mysql
                    ps.setDate(11,isqldate);
                    ps.setDate(12,rsqldate);
                    ps.setLong(13,SMobNo);
                    ps.setDate(14,null);
                    int count=ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Details stored successfully..");
                    con.close();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField9 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("LMS.No");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(510, 140, 53, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(510, 200, 40, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 255));
        jLabel3.setText("RegNo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(510, 260, 47, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 255));
        jLabel4.setText("Dept");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(510, 310, 33, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 255));
        jLabel5.setText("ContactNo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(510, 370, 75, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 255));
        jLabel6.setText("Student Details");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(700, 100, 138, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 204, 255));
        jLabel7.setText("BookID");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 160, 53, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 255));
        jLabel8.setText("Name");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 220, 40, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 255));
        jLabel9.setText("Author");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 270, 49, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 204, 255));
        jLabel10.setText("Type");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 330, 34, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 204, 255));
        jLabel11.setText("Regulations");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 390, 81, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 204, 255));
        jLabel12.setText("Publications");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 450, 82, 17);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 204, 255));
        jLabel13.setText("IssuedDate");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(40, 520, 79, 17);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 204, 255));
        jLabel14.setText("ReturnDate");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(40, 570, 80, 17);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 204, 255));
        jLabel15.setText("Book Details");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(50, 100, 112, 22);

        jTextField1.setBackground(new java.awt.Color(255, 102, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(670, 130, 200, 35);

        jTextField2.setBackground(new java.awt.Color(255, 102, 255));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(670, 190, 200, 34);

        jTextField3.setBackground(new java.awt.Color(255, 102, 255));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField3.setEnabled(false);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(670, 250, 200, 34);

        jTextField5.setBackground(new java.awt.Color(255, 102, 255));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField5.setEnabled(false);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(670, 360, 200, 37);

        jTextField6.setBackground(new java.awt.Color(255, 102, 255));
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(140, 150, 194, 35);

        jTextField7.setBackground(new java.awt.Color(255, 102, 255));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField7.setEnabled(false);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(140, 210, 194, 37);

        jTextField8.setBackground(new java.awt.Color(255, 102, 255));
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField8.setEnabled(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField8);
        jTextField8.setBounds(140, 270, 194, 38);

        jComboBox1.setBackground(new java.awt.Color(255, 102, 255));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select--", "Novels", "University Books", "Magazines", "Others" }));
        jComboBox1.setEnabled(false);
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(140, 330, 194, 34);

        jComboBox2.setBackground(new java.awt.Color(255, 102, 255));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select--", "2013", "2017", "Other Regulations", "No Regulations" }));
        jComboBox2.setEnabled(false);
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(140, 380, 194, 33);

        jTextField9.setBackground(new java.awt.Color(255, 102, 255));
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 255), 2, true));
        jTextField9.setEnabled(false);
        getContentPane().add(jTextField9);
        jTextField9.setBounds(140, 430, 190, 40);

        jDateChooser1.setBackground(new java.awt.Color(255, 102, 255));
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(140, 500, 190, 30);

        jDateChooser2.setBackground(new java.awt.Color(255, 102, 255));
        getContentPane().add(jDateChooser2);
        jDateChooser2.setBounds(140, 550, 190, 30);

        jButton1.setBackground(new java.awt.Color(255, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Issue");
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
        jButton1.setBounds(580, 440, 135, 69);

        jButton2.setBackground(new java.awt.Color(255, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Clear");
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
        jButton2.setBounds(780, 440, 122, 69);

        jComboBox3.setBackground(new java.awt.Color(255, 102, 255));
        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select--", "CSE", "EEE", "ECE", "Mech", "Civil", "MCA", "MBA", "Arts & Commerce", "Others" }));
        jComboBox3.setAutoscrolls(true);
        jComboBox3.setEnabled(false);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(670, 310, 200, 37);

        jButton3.setBackground(new java.awt.Color(255, 102, 255));
        jButton3.setText("BACK");
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
        jButton3.setBounds(910, 70, 70, 30);

        jButton4.setBackground(new java.awt.Color(255, 102, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("SEARCH");
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
        jButton4.setBounds(340, 150, 90, 30);

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
        jButton5.setBounds(880, 130, 90, 30);

        jButton6.setBackground(new java.awt.Color(255, 51, 255));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sai\\Downloads\\iconfinder_button_close_352915 (1).png")); // NOI18N
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(970, 0, 40, 30);

        jButton7.setBackground(new java.awt.Color(255, 102, 255));
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sai\\Downloads\\iconfinder_minus_1303882.png")); // NOI18N
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(930, 0, 40, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/Untitled design (2).png"))); // NOI18N
        jLabel16.setText("jLabel16");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(0, -110, 1040, 820);

        setSize(new java.awt.Dimension(1007, 599));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Issuebooks();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        LMenupage lm=new LMenupage();
        lm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        bookauto();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        studentauto();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setBackground(Color.red);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        jButton6.setBackground(pink);
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        jButton7.setBackground(Color.GRAY);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
        jButton7.setBackground(pink);
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(LibrarianLogin.ICONIFIED);
        //102,102,255
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setCursor(hand);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jButton5.setCursor(hand);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setCursor(hand);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setCursor(hand);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setCursor(hand);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
       // jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jComboBox1.setSelectedIndex(0);
         jComboBox2.setSelectedIndex(0);
          jComboBox3.setSelectedIndex(0);
          jDateChooser1.setDateFormatString("");
                    jDateChooser2.setDateFormatString("");

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Issuebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issuebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issuebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issuebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issuebooks().setVisible(true);
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
