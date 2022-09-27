package ch01;

import java.util.Scanner;

public class Median {

    static int med3(int a, int b, int c) {

        if (a >= b) {
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        }
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1, num2, num3;

        System.out.println("세 정수의 중앙값");
        System.out.print("num1 : ");
        num1 = sc.nextInt();
        System.out.print("num2 : ");
        num2 = sc.nextInt();
        System.out.print("num3 : ");
        num3 = sc.nextInt();

        System.out.println("세 정수의 중앙값은 " + med3(num1, num2, num3) + " 입니다." );
    }
}
