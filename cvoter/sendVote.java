/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvoter;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author abhimanyuyadav
 */
public class sendVote implements Runnable {
   
    String ip = "";
    public sendVote(String ip1)
    {
        ip = ip1;
    }
    public static void main(String args[])
    {
        
    }

    /**
     *
     */
  

    @Override
    public void run() {
        Socket s = null;
        
        try {
            s = new Socket(ip,8080);
        } catch (IOException ex) {
            System.out.println("Error with socket connection");
        }
        try
        {
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String x = dis.readUTF();
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.println(x);
            int a = -1;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter data ");
            String d = br.readLine();
            a = Integer.valueOf(d);
            dout.writeInt(a);
            
            s.close();
            System.out.println("Connection closed successfully");
        }
        catch(Exception e)
        {
            System.out.println("Error in during excecution");
        }
    }
   
}
