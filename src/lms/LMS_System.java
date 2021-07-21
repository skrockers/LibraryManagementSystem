/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;
import java.sql.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.*;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
/**
 *
 * @author Sai
 */
public class LMS_System {
public static void FineCalculator()
{
    
    try
    {
        java.sql.Date rtdate;
        java.util.Date cdate;
      String default_name="root";
        String default_password="12345";
        //connection database
        String url="jdbc:mysql://localhost:3306/lms";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,default_name,default_password);
        String query="select *from blacklist";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
             rtdate=rs.getDate(12);
             cdate=new java.util.Date();
            System.out.println(rtdate);
            System.out.println(cdate);
            
            
        }
       //System.out.println(rtdate);
    }
    catch(Exception e)
    {
        //JOptionPane.showMessageDialog(null,e);
        System.out.println(e);
    }
}
  public  static void sendsms()
  {
      try
      {
          List<String> sender=new ArrayList<String>();
          String uname="root";
          String pwd="12345";
          String url="jdbc:mysql://localhost:3306/lms";
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection(url,uname,pwd);
          String query="select * from blacklist";
          Statement st=conn.createStatement();
          ResultSet rs=st.executeQuery(query);
          
          while(rs.next())
          {
           String num =rs.getString(13);
           sender.add(num);
          }
          String number=String.join(",",sender);
          System.out.println("Str:"+number);
            String message="Thank you for using SK Library.Your book validity date has been expired Please return or Renew the book From SK Library";
          //   String message="Java Test Message"; 
             String Apikey="RxOTNmPXezAfyHlQY8EvqpwMFjt2uVnds9aIcgr06WhBobDGC3ogX9cnLaVuUPFyljWrMTNtEYbqO4H0";
              String senderid="FSTSMS";
              message=URLEncoder.encode(message, "UTF-8");
              String language="english";
              String route="p";
           JOptionPane.showMessageDialog(null,"Connecting...");
           String myurl="https://www.fast2sms.com/dev/bulk?authorization="+Apikey+"&sender_id="+senderid+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
          JOptionPane.showMessageDialog(null,myurl);
        URL urls=new URL(myurl);
           HttpsURLConnection con=(HttpsURLConnection)urls.openConnection();
           con.setRequestMethod("GET");
           con.setRequestProperty("User-Agent","Chrome");
           con.setRequestProperty("cache-control","no-cache");
           JOptionPane.showMessageDialog(null,"Please Wait.");
           int code=con.getResponseCode();
           JOptionPane.showMessageDialog(null,"Response Code:"+code);
           StringBuffer response=new StringBuffer();
           BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream())); 
           while(true)
           {
               String line=br.readLine();
               if(line==null)
               {
                   break;
               }
               response.append(line);
           }
           JOptionPane.showMessageDialog(null,response); 
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
 }
   
    
   public static void main(String[]args)
{
sendsms();
}

}
