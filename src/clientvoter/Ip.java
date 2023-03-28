/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvoter;

/**
 *
 * @author abhimanyuyadav
 */
import java.net.*;
import java.util.Enumeration;
public class Ip {
    
    public static void main(String args[]) throws SocketException 
    {
        
       System.out.println(IP());
    }
    public static String IP() throws SocketException
    {
         Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
    while (interfaces.hasMoreElements()) {
        NetworkInterface iface = interfaces.nextElement();
        if (iface.isLoopback() || !iface.isUp() || iface.isVirtual() || iface.isPointToPoint())
            continue;

        Enumeration<InetAddress> addresses = iface.getInetAddresses();
        while(addresses.hasMoreElements()) {
            InetAddress addr = addresses.nextElement();

            final String ip = addr.getHostAddress();
            if(Inet4Address.class == addr.getClass()) 
               return ip;
        }
    }
        return null;
    }
        }
    
    

