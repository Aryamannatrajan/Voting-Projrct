/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvoter;

import java.io.DataInputStream;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author abhimanyuyadav
 */
public class WaitAndConfirm implements Runnable {

    @Override
    public void run() {
        
        boolean command = true;
                try {
                    String urL = "jdbc:mysql://localhost:3306/TBS?zeroDateTimeBehavior=CONVERT_TO_NULL";
                    String user = "root";
                    String pass = "TBS@admin123";
                    Connection conn = DriverManager.getConnection(urL, user, pass);
                    while(command){
                        
                    
                    Statement st = conn.createStatement();
                    String q1 = "SELECT * FROM COMMAND";
                    ResultSet rs = st.executeQuery(q1);
                    
                    while(rs.next())
                    {
                        if(rs.isFirst())
                        {
                        int check = rs.getInt("com");
                        if(check == 1){
                            command = false;
                        break;
                        }
                        }
                    }
                    
                    }
                    
        
    }   catch (SQLException ex) {
            Logger.getLogger(WaitAndConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void main(String args[])
    {
        
    }
    
}
