package ex02;

import java.util.Scanner;

public class program {
	public static void main(String[] args) {
		Scanner userValue = new Scanner(System.in);
		int n = 2;
		int i = 3;
		int request = 0;
		try {
			while (n != 42){
				n = userValue.nextInt();

				if(n <= 1){
					System.out.println("Illegal Argument");
					System.exit(-1);
				}else if(result(n)){
					request++;
				}
			}
			System.out.println("Count of coffee-request – " + request);
		} catch (Exception e) {
			System.out.println("Error");
			System.exit(-1);
		}
	}

	static int length(int n){
		int i = 0;
		while (n > 0){
			n = n /10;
			i++;
		}
		return i;
	}

	static boolean result(int sum){
        int length = length(sum);
        int	result = 0;
        for (int i = 0; i < length; i++)
        {
            result += sum % 10;
            sum /= 10;
        }
//		System.out.println(result);
		if(result < 2){
			return false;
		}else
			return checkIsItANaturalNumber(result);
	}
	private static boolean checkIsItANaturalNumber(int n) {
			int i = 2;
			while (i <= n) {
				if (n % i == 0 && n != i){
					return false;
				}
				i++;
			}
				return true;
	}
}

