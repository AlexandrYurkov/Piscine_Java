package src.java.edu.school21.printer.logic;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.Parameter;


import java.io.IOException;

@Parameters(separators = "=")
public class Args {

   @Parameter(names = {"--white"})
   public String white;
   @Parameter(names = {"--black"})
   public String black;

   public void run() throws IOException {
      Logic logic = new Logic(white, black);
      logic.printImage();
   }
}
