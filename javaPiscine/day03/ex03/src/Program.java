//package ex03;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Program {

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

    public static void main(String[] args) {
//        int countThreads = Integer.parseInt(args[0].split("=")[1]);
       int countThreads = 3;

        File file_urls = new File("src/files_urls.txt");
        ArrayList<String> str = new ArrayList<>();
        try {
            str = fileReader(file_urls);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assert str != null;
        DownloadsFile downloadsFile = new DownloadsFile(str, countThreads);
        try {
            downloadsFile.downloads();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}