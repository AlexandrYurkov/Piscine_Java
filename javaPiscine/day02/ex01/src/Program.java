import java.io.*;
import java.util.*;

public class Program {
    public static String[] reader(File file) throws IOException {
        FileReader readerA = new FileReader(file);
        int c;
        StringBuilder str = new StringBuilder();
        while ((c = readerA.read()) != -1){
            str.append((char) c);
        }
        String[] mass = str.toString().split(" ");

        readerA.close();
        return mass;
    }

    private static void writer(Set<String> result) throws IOException {
        File dictionary = new File( "dictionary.txt");
        boolean check = dictionary.createNewFile();
        System.out.println(dictionary.exists());
        if(check) {
            FileWriter writer = new FileWriter(dictionary);
            int i = 1;
            for(String s : result) {
                if(result.size() == i++)
                    writer.write(s + "\n");
                else
                    writer.write(s + ", ");
            }
            writer.flush();
            writer.close();
        }
    }

    public static TreeSet<String> dictionary(String[] strA, String[] strB) throws IOException {
        ArrayList<String> tmp = new ArrayList<>(Arrays.asList(strB));
        tmp.addAll(Arrays.asList(strA));
        TreeSet<String> result = new TreeSet<>(tmp);
        writer(result);
        return result;
    }
//перепесать функцию счета
    private static int[] countNumber(Map<String, Integer> count, String[] str, TreeSet<String> dictionary){
        int[] result = new int[dictionary.size()];
        int i = 0;
        ArrayList<String> dict = new ArrayList<>(dictionary);
        for (String s : dict) {
            for (int j = 0; j < str.length; j++) {
                if (s.equals(str[j]) && i < dict.size()) {
                    count.put(str[j], count.get(str[j]) + 1);
                    result[i] = count.get(str[j]);
                }
            }
            i++;
        }
        return result;
    }

    private static double denominator(int[] x){
        double a = 0.0;
        for (int i : x)
            a += i*i;
        return Math.sqrt(a);
    }

    public static double sumResult(int[] keyA, int[] keyB){
        double denominator = 0.0;
        double numerator = 0.0;
        for(int i = 0; i < keyA.length; i++)
            numerator += keyA[i] * keyB[i];
        denominator = denominator(keyA) * denominator(keyB);
        return numerator / denominator;
    }

    public static double similarity(String[] strA, String[] strB, TreeSet<String> dictionary){
        Map<String, Integer> count = new HashMap<>();
        for(String s : dictionary)
            count.put(s, 0);
        int[] keyA = countNumber(count, strA, dictionary);
        int[] keyB = countNumber(count, strB, dictionary);
        return sumResult(keyA, keyB);
    }

    public static void main(String[] args) {

        File fileA = new File(args[0]);
        File fileB = new File(args[1]);
        try {
            String[] strA = reader(fileA);
            String[] strB = reader(fileB);
            TreeSet<String> dictionary = dictionary(strA, strB);
            System.out.printf("%.2f\n", similarity(strA, strB, dictionary));

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}