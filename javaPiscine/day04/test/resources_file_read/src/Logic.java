
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logic {
    private final File file;

    public Logic(String file) throws IOException{
        this.file = new File(file);
        checkPATH();
    }
    private void checkPATH() throws IOException {
        if(!file.exists())
            throw new IOException("Bad path_file!");
    }
    public void printImage() throws IOException {
        BufferedImage img = ImageIO.read(file);
            for (int yPixel = 0; yPixel < img.getWidth(); yPixel++) {
                for (int xPixel = 0; xPixel < img.getHeight(); xPixel++) {
                    int color = img.getRGB(xPixel, yPixel);
                    if (color == Color.BLACK.getRGB())
                        System.out.print(" 0 ");
                    else
                        System.out.print(" . ");
                }
                System.out.println();
        }
    }
}
