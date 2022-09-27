package ch01;

import java.util.Scanner;

public class Max3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;
        int num3;

        System.out.println("세 정수의 최대값을 구합니다.");
        System.out.print("num1 : ");
        num1 = sc.nextInt();
        System.out.print("num2 : ");
        num2 = sc.nextInt();
        System.out.print("num3 : ");
        num3 = sc.nextInt();

        int max = num1;
        if (max < num2) {
            max = num2;
        }
        if (max < num3) {
            max = num3;
        }

        System.out.println("세 정수의 최대값은 " + max + "입니다.");
    }
}
