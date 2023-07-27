import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, String> signatures = new TreeMap<>();
        try {
            FileInputStream file =
                    new FileInputStream(System.getProperty("user.dir") + "/src/signatures.txt");
            StringBuilder tempStr = new StringBuilder();
            int ch;

            while ((ch = file.read()) != -1) {
                if ((char)ch == '\n' || file.available() == 0) {
                    String[] line = tempStr.toString().split(",");
                    signatures.put(line[1].trim(), line[0]);
                    tempStr.setLength(0);
                    continue;
                }
                tempStr.append((char)ch);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String path;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter path to file:");

        while (!(path = scan.nextLine()).equals("42")) {

            StringBuilder hex = new StringBuilder();
            FileInputStream inputFile = null;

            boolean isDefined = false;
            FileOutputStream outputFile = null;
            try {
                outputFile =
                        new FileOutputStream(System.getProperty("user.dir") + "/src/result.txt", true);
                inputFile = new FileInputStream(path);
                for (int i = 0; i < 8 && inputFile.available() > 0; i++) {
                    System.out.printf("%02X ", inputFile.read());
//                    hex.append(String.format("%02X ", inputFile.read()));
                }
                String sign = hex.toString();
                String value;
                for (String key : signatures.keySet()) {
                    if (sign.startsWith(key)) {
                        value = signatures.get(key);
                        outputFile.write(value.getBytes());
                        System.out.println(Arrays.toString(value.getBytes()));
                        outputFile.write('\n');
                        System.out.println("PROCESSED");
                        System.out.println("Enter path to file:");
                        isDefined = true;
                    }
                }
                if (!isDefined)
                {
                    System.out.println("UNDEFINED");
                    System.out.println("Enter path to file:");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputFile != null)
                        inputFile.close();
                    if (outputFile != null)
                        outputFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        scan.close();
    }
}