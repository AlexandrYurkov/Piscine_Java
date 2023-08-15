package src.java.edu.school21.printer.app;

import src.java.edu.school21.printer.logic.Logic;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try{
            if(args.length == 0){
                System.out.println("No args!");
                System.exit(-1);
            }
            String path = args[0];
            Logic img = new Logic(path);
            img.printImage();
        }catch (IOException e){
            System.out.println("AAAAA CRACH ERROR " + e.getMessage());
        }
    }
}
