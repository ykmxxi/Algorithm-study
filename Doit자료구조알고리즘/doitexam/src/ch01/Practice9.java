package ch01;

import java.util.Scanner;

public class Practice9 {

    public static void main(String[] args) {

        int a, b;
        Scanner sc = new Scanner(System.in);

        System.out.print("a 값 : ");
        a = sc.nextInt();
        System.out.print("b 값 : ");
        b = sc.nextInt();

        while (true) {
            if (b > a)
                break;
            System.out.println("a 보다 큰 값을 입력하세요");
            System.out.print("b 값 : ");
            b = sc.nextInt();
        }

        System.out.println("b - a는 " + (b - a) + "입니다.");

    }
}
