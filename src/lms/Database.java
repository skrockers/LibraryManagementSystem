/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Sai
 */
public class Database {
    Connection con=null;
    public static Connection Connectdb()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql:lmsdata.db");
            return con;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}
