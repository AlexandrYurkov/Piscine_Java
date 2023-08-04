import java.util.ArrayList;
import java.util.Arrays;
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

        private int ThreadsCount = 0;
        Summa sum;

        public Totalizer(int start, int end, int[] array, Summa summa) {
            this.start = start;
            this.end = end;
            this.array = array;
            this.sum = summa;
        }

        public int getResult() {
            return result;
        }

        private void totalizer(){
            for(int i = start; i < end; i++){
                result += array[i];
            }
            System.out.println("Summa total = " + sum.getSumma());
            sum.setSumma(result);
        }

        @Override
        public void run() {
            totalizer();
            System.out.printf("Thread %d: from %d to %d sum is %d\n", this.ThreadsCount, start, end, result);
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

    private static int[] step(int arraySize, int threadsCount){
         int step = (int)Math.round((double) arraySize / threadsCount);
         int[] steps = new int[threadsCount];
         for (int i = 0; i < threadsCount; i++) {
             if (i == 0)
                 steps[i] = 0;
             else
                 if(steps[i-1] + step <= arraySize)
                    steps[i] = steps[i-1] + step;
                 else
                     steps[i] = arraySize;
         }
         return steps;
    }
    private static int checkSum(int[] result){
        int checkSum = 0;
        for (int j : result) checkSum += j;
        return checkSum;
    }

    public static void main(String[] args) throws InterruptedException {
        int arraySize = parserInt(args[0]);
        int threadsCount = parserInt(args[1]);
        int[] result = generator(arraySize);
        int[] steps = step(arraySize, threadsCount);
        Summa summa = new Summa(0);
        for (int i = 0; i < threadsCount;  i+=2){
            Totalizer count = new Totalizer(steps[i], steps[i+1], result, summa);
            System.out.println(count.start + ": " + count.end);
            Thread thread = new Thread(count);
            thread.start();
            System.out.println(count.getResult());
            if(threadsCount%2 == 1){
                Totalizer tail = new Totalizer(steps[threadsCount-2], steps[threadsCount-1], result, summa);
                Thread threadTail = new Thread(tail);
                threadTail.start();
                threadTail.join();
                System.out.println("tail");
            }
        }
        System.out.println(Arrays.toString(steps));
        System.out.println(Arrays.toString(result));
        System.out.println("checkSum = " + checkSum(result));
        System.out.println("SummaThreads = " + summa.getSumma());
    }
}