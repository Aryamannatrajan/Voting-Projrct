/*
 * Copyright (C) 2020 abhimanyuyadav
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package adminvoter;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abhimanyuyadav
 */
public class ServerTh implements Runnable{

    Socket s = null;
    ServerTh(Socket s)
    {
        this.s = s;
    }
    @Override
    public void run() {
        try {
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hi Client! You can send data and use 'EXIT' to leave.");
            
            
        } catch (IOException ex) {
            System.out.println("Error with sending data");
        }
        
    
    }
    public int update()
    {
        int x = -1;
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(s.getInputStream());
            
            x= dis.readInt();
            
            
        }
        catch(EOFException e1)
        {
            return 0;
        }catch (IOException ex ) {
            
            try
            {
                Logger.getLogger(ServerTh.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception e1)
            {
                System.out.println("Exception Handled..........1212");
            }
        } finally {
            try {
                dis.close();
                s.close();
                return x;
            } catch (IOException ex) {
                System.out.println("Input Output Exception");
            }
        }
        return x;
    }
}
