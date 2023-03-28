package clientvoter;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author abhimanyuyadav
 */
public class Ser {
    
    public static void main(String args[])
    {
        
        for(int i=0; i < 10; i++)
        {
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s;
            s = ss.accept();
            
            File f = new File("C:\\Users\\dhiro\\OneDrive\\Documents\\College Application\\Data\\passport_photo.jpg");
            BufferedImage bi = ImageIO.read(f);
            ImageIO.write(bi, "JPG", s.getOutputStream());
            s.close();
            ss.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Ser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
    
}
