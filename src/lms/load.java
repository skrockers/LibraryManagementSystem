/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

/**
 *
 * @author Sai
 */
public class load {
   
    
    public static void main(String[]args)
    {
        Loading ld=new Loading();
        ld.setVisible(true);
        LibrarianLogin lg=new LibrarianLogin();
        
        try
        {
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(50);
                ld.jProgressBar1.setValue(i);
                ld.jLabel1.setText("Loading...."+i+"%");
                if(i==100)
                {
                   lg.design(); 
                  lg.setVisible(true);
                  
                  ld.dispose();
                  
                }
            }
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception e)
        {
            
        }
        
    }
    
}
