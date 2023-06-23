import java.util.Scanner;

public class Program{
    public static int COUNT = 0;
    public static long DATA = 1;
    public static int NUMBERWEEK = 1;
 
    public static void main(String[] args) {
        String eof = "42";
        String line = "";
        
        Scanner sc = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);

            while(COUNT < 18){
                line = sc.nextLine().toLowerCase();
                String nextWeek = "week " + (COUNT + 1);
                if(line.equals(eof)){
                    valueData();
                    System.exit(0);
                }  
                if(!line .equals(nextWeek)){
                    System.err.println("BOLT");
                    System.exit(-1);
                }             
                int value = 9;
                for(int i = 0; i < 5; i++){
                    int v = scInt.nextInt();
                      value = value > v ? v : value;
                }
                DATA = (DATA * 10) + value;
                COUNT++;
            }
            sc.close();
            scInt.close();
    }
    
    private static void printValue(int value){
        String result = "";
        for(int i = value; i > 0; i--){
            result = result + "=";
        }
        System.out.println("week " + NUMBERWEEK + " " + result + ">");
        NUMBERWEEK++;
    }
    private static void valueData(){
        for(int i = COUNT; i > 0; i--){
            long value = DATA;
            for(int j = i - 1; j > 0; j--)
                value /= 10;
            printValue((int)value%10);
        }
    }
}