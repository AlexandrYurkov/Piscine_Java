import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;


public class Program {
    public static void main(String[] args) throws IOException{
        String[] profile = args[0].split("=");
        Menu menu = new Menu(profile[1]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String str = reader.readLine();
                if (str.equals("7"))
                    break;
                menu.managerMenu(Integer.parseInt(str));

            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                menu.toStringMenu();
            }


        }
    }


}