package src.java.edu.school21.printer.app;

import src.java.edu.school21.printer.logic.Logic;
import java.io.IOException;
import java.net.URL;

public class App {
    public static void main(String[] args) {
        try{
            Logic img = new Logic("./target/resources/it.bmp");
            img.printImage();
        }catch (IOException e){
            System.out.println("AAAAA CRACH ERROR " + e.getMessage());
        }
    }
}
