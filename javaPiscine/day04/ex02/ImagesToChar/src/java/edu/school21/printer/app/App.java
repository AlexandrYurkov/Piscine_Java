package src.java.edu.school21.printer.app;
import com.beust.jcommander.*;
import src.java.edu.school21.printer.logic.Args;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Args arg = new Args();
        JCommander.newBuilder().addObject(arg).build().parse(args);
        try{
            arg.run();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}