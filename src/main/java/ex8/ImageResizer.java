package ex8;

import ex7.LoanInfoServlet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class ImageResizer {

    private final static Logger logger = Logger.getLogger(LoanInfoServlet.class.getName());

//    Scanner scanner = new Scanner(System.in);
//
//    public String getSourceImagePath() {
//        String sourceImagePath = scanner.nextLine();
//        return sourceImagePath;
//    }

    public static void resize (String sourceImagePath, String resizedImagePath) throws IOException {

        File sourceFile = new File(sourceImagePath);
        BufferedImage sourceImage = ImageIO.read(sourceFile);

        int resizedWidth = sourceImage.getWidth() / 2;
        int resizedHeight = sourceImage.getHeight() / 2;

        BufferedImage resizedImage = new BufferedImage(resizedWidth, resizedHeight, sourceImage.getType());

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(sourceImage, 0, 0, resizedWidth, resizedHeight, null);
        g2d.dispose();

        String formatName = resizedImagePath.substring(resizedImagePath.lastIndexOf(".") + 1);

        ImageIO.write(resizedImage, formatName, new File(resizedImagePath));
        
    }

}