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


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abhimanyuyadav
 */
public class T1 {

    int x = 0;
    int cnt = 0;
    ServerSocket ss = new ServerSocket(8080,100);
    Socket s = null;
    
    T1() throws IOException
    {
        
       
    }
    public Socket updates() throws InterruptedException, IOException
    {
        
        
        try {
            s = ss.accept();
           Thread t1 = new Thread(new ServerTh(s));
           t1.start();
           
            return s;
        } catch (IOException ex) {
            Logger.getLogger(T1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
