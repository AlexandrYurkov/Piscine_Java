import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Program {
    public static class Summa{
        int summa;

        public Summa(int summa) {
            this.summa = summa;
        }

        public int getSumma() {
            return summa;
        }

        public void setSumma(int summa) {
            this.summa += summa;
        }
    }
    public static class Totalizer implements Runnable{
        private int start;
        private int end;
        private int[] array;
        private Integer result = 0;

        private int threadsCount = 0;
        Summa sum;

        public Totalizer(int threadsCount, int start, int end, int[] array, Summa summa) {
            this.start = start;
            this.end = end;
            this.array = array;
            this.sum = summa;
            this.threadsCount = threadsCount;
        }

        public int getResult() {
            return result;
        }

        private void totalizer(){
            for(int i = start; i < end; i++){
                result += array[i];
            }
            sum.setSumma(result);
        }

        @Override
        public void run() {
            totalizer();
            System.out.printf("Thread %d: from %d to %d sum is %d\n", this.threadsCount, start, end, result);
        }
    }

    private static int parserInt(String s){
        String[] str = s.split("=");
        return Integer.parseInt(str[1]);
    }

    private static int[] generator(int arraySize){
        int[] result = new int[arraySize];
        Random r = new Random();
        for(int i = 0; i < arraySize; i++)
            result[i] = r.nextInt(1000);
        return result;
    }

    private static int step(int arraySize, int threadsCount){
         return (int)Math.round((double) arraySize / threadsCount);
    }
    private static int checkSum(int[] result){
        int checkSum = 0;
        for (int j : result) checkSum += j;
        return checkSum;
    }

    private static ArrayList<Totalizer> total(int steps, int threadsCount, int[] result, Summa summa){
        ArrayList<Totalizer> total = new ArrayList<>();
        int tailSteps = 0;
        int nextSteps = steps;
        for (int i = 0; i < threadsCount;  i++){
            if(i+1 >= threadsCount && nextSteps < result.length){
                nextSteps = result.length;
                Totalizer count = new Totalizer(threadsCount, tailSteps, nextSteps, result, summa);
                total.add(count);
                break;
            }
            Totalizer count = new Totalizer(i+1, tailSteps, nextSteps, result, summa);
            total.add(count);
            if(nextSteps + steps >= result.length) {
                tailSteps = nextSteps;
                nextSteps = result.length;
            }
            else{
                tailSteps = nextSteps;
                nextSteps += steps;
            }
        }
        return total;
    }

    public static void main(String[] args) throws InterruptedException {
        int arraySize;
        int threadsCount;
        try {
             arraySize = parserInt(args[0]);
             threadsCount = parserInt(args[1]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Аргументы отсутствуют " + e.getMessage());
            arraySize = 10;
            threadsCount = 3;
        }
        int[] result = generator(arraySize);
        int steps = step(arraySize, threadsCount);
        Summa summa = new Summa(0);
        ArrayList<Totalizer> total = total(steps, threadsCount, result, summa);

        for (Totalizer count : total){
            Thread thread = new Thread(count);
            thread.start();
            thread.join();
        }


        System.out.println("checkSum = " + checkSum(result));
        System.out.println("SummaThreads = " + summa.getSumma());
//        System.out.println(Arrays.toString(result));
    }
}