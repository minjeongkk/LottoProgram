package StringAddCalculator;

import java.util.Scanner;

public class StringAddCalculatorExecutor {
    public static void main(String[] args){
        run();
    }

    public static void run(){
        printInfo();

        // 값 입력
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();

        // 계산
        int result = StringAddCalculator.splitAndSum(inputValue);
        printResult(result);
    }

    public static void printInfo(){
        System.out.println("계산할 값을 입력하세요.");
    }

    public static void printResult(int result){
        System.out.println("계산 결과: "+result);
    }
}