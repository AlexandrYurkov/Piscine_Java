package src.java.edu.school21.printer.logic;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Logic {
    private final File file;
    private String white;
    private String black;


    public Logic(String file) throws IOException{
        this.file = new File(file);
        checkPATH();
    }

    public Logic(String white, String black) throws IOException{
        this.file = new File("target/resources/it.bmp");
        this.white = white;
        this.black = black;
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
                ColoredPrinter print = new ColoredPrinter();
                int color = img.getRGB(xPixel, yPixel);
                if (color == Color.BLACK.getRGB())
                    print.print("   ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(black));
                else
                    print.print("   ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(white));
            }
            System.out.println();
        }
    }
}