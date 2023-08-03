import java.lang.*;

public class Program {

    public static class Printer implements Runnable{
        private final String str;
        public Printer(String str) {
            this.str = str;
        }

        @Override
        public void run() {
            System.out.println(str);
        }
    }

    private static int parserInt(String s){
        String[] str = s.split("=");
        return Integer.parseInt(str[1]);
    }
    public static void main(String[] args){
        int count = parserInt(args[0]);
        Printer egg = new Printer("EGG");
        Printer hen = new Printer("HEN");

        try{
            for (int i = 0; i < count -1; i++){
            Thread threadEgg = new Thread(egg);
            Thread threadHen = new Thread(hen);
            threadEgg.start();
            threadHen.start();
            threadHen.join();
            threadEgg.join();
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        Thread human = new Thread(new Printer("HUMAN"));
        human.start();
    }
}