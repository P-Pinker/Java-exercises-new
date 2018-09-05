package ex8;

import ex7.LoanInfoServlet;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageResizer {

    private final static Logger logger = Logger.getLogger(LoanInfoServlet.class.getName());

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

    public static void main(String[] args) {

        String sourceImagePath1 = "C:\\Users\\ppinker\\Downloads\\IMG_20180820_142034.jpg";
        String resizedImagePath1 = "C:\\Users\\ppinker\\Downloads\\IMG_20180820_142034-small.jpg";

        try {
            ImageResizer.resize(sourceImagePath1, resizedImagePath1);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd.");
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

}