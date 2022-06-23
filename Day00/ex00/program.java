package ex00;

public class program {
//    static void result(int sum){
//        int length = String.valueOf(sum).length();
//        int	result = 0;
//        for (int i = 0; i < length; i++)
//        {
//            result += sum % 10;
//            sum /= 10;
//        }
//        System.out.println(result);
//
//    }

    static void result(int sum){
        int	result = 0;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        System.out.println(result);

    }

    public static void main(String[] args) {
        int sumThis = 479598;
        int test = 125481;
        result(sumThis);
        result(test);
    }
}
