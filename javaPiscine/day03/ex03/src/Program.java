import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Program {
    public static void downloadFile(URL url, String fileName) throws IOException {
        try (InputStream in = url.openStream();
             BufferedInputStream bis = new BufferedInputStream(in);
             FileOutputStream fos = new FileOutputStream(fileName)) {

            byte[] data = new byte[1024];
            int count;
            while ((count = bis.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, count);
            }
        }
    }

    public static ArrayList<String> fileReader(File file) throws IOException {
        try (FileReader reader = new FileReader(file)) {
            int c;
            StringBuilder s = new StringBuilder();
            while ((c = reader.read()) != -1) {
                s.append((char) c);
            }
            String str = s.toString();
            return new ArrayList<>(Arrays.asList(str.split("\n")));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static HashMap<Integer, URL> stringURL(ArrayList<String> src) throws MalformedURLException {
        HashMap<Integer, URL> url = new HashMap<>();
        for (String value : src) {
            String[] s = value.split(" ");
            URL uri = new URL(s[1]);
            url.put(Integer.parseInt(s[0]), uri);
        }
        return url;
    }

    public static String fileName(String str) {
        String[] name = str.split("/");
        return name[name.length - 1];
    }

    public static void downloads(ArrayList<String> str) throws IOException {
        HashMap<Integer, URL> list = stringURL(str);
        for (URL value : list.values())
            downloadFile(value, fileName(value.toString()));
    }

    public static void main(String[] args) {
        File file_urls = new File("src/files_urls.txt");
        ArrayList<String> str = new ArrayList<>();
        try {
            str = fileReader(file_urls);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assert str != null;
        try {
            downloads(str);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}