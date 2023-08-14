import java.io.IOException;
import java.net.URL;
public class App {
    public static void main(String[] args){
        try{
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL path = classloader.getResource("it.bmp");
            assert path != null;
            Logic img = new Logic(path.getPath());
            img.printImage();
        }catch (IOException e){
            System.out.println("AAAAA CRACH ERROR " + e.getMessage());
        }
    }
}
