/*
 * Copyright (C) 2020 dhiro
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

/**
 *
 * @author dhiro
 */
 
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
import java.io.File;

import java.io.File;

public class ImageResizer {
 
    public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 

        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 

        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
 
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
 
    
    }
 
