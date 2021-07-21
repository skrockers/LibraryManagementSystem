/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Sai
 */
public class rough2 {
    public static void Actual()
{
   try
    {
        Date d=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    String s=sdf.format(d);
    System.out.println(s);
    
        //required Attributes
       // int ReturnBookId=Integer.parseInt(jTextField1.getText());
        //default login
        String default_name="root";
        String default_password="12345";
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,default_name,default_password);  
        String query1="insert into returnbooks (ActualReturnDate) values(?)";
        PreparedStatement ps=con.prepareStatement(query1);
       ps.setString(14, s);
        int count=ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Sucess");
        //-----------------------------------------------------------------------------------------------------------------//
        con.close();
        ps.close();
    }
    
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error found in returnbooks:"+e);
    }  
}

public static void main(String[]args)
{
Actual();
}
}