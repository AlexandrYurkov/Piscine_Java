package ex03;

import java.util.Scanner;

public class program {
	private static String str;
	private static int numberWeek = 0;
	private static long dataGrade = 0;
	private static int checkWeek = 1;

	public static void main(String[] args) {
		Scanner week = new Scanner(System.in);
		Scanner data = new Scanner(System.in);
		while (true) {
			str = week.next();
			if(str.equals("42")){
				data.close();
				week.close();
				break;
			}
			if (!str.equals("Week")) {
				data.close();
				week.close();
				printError(str);
			}
			numberWeek = week.nextInt();

		if(numberWeek != checkWeek++){
			data.close();
			week.close();
			printError("numberWeek");
		}
			int i = 0;
			int minValue = 10;

			while (i < 5) {
				int value = 0;
				try {
					value = data.nextInt();
				} catch (Exception e) {
					printError("Value");
				}
				if (value > 10) {
					data.close();
					week.close();
					printError("value");
				}
				if (value < minValue) {
					minValue = value;
				}
				i++;
			}
			dataValue(minValue);
			numberWeek++;
		}
		data.close();
		week.close();
		resultPrint();
	}

	private static int length(long n){
		int i = 0;
		while (n > 0){
			n = n /10;
			i++;
		}
		return i;
	}

	private static void dataValue(int num) {
		dataGrade *= 10;
		dataGrade += num;
	}

	private static int parserLong(long tmp){
		int length = length(tmp);
		long j = 1;
		for(int i = length - 1; i > 0; i--)
			tmp /= 10;
		for(int i = 1; i < length; i++)
			j *=10;
		dataGrade = dataGrade % j;
		return (int)tmp % 10;
	}

	private static void printError(String mass){
		System.err.println("IllegalArgument : " + mass);
		System.exit(-1);
	}
	private static void resultPrint(){
		int i = 1;
		System.out.println(dataGrade);
		while (numberWeek - 1 > 0) {
			System.out.print("Week " + i + " ");
			int minValue = parserLong(dataGrade);
			while (minValue > 0) {
				System.out.print("=");
				minValue--;
			}
			System.out.print(">\n");
			numberWeek--;
			i++;
		}
	}
}
