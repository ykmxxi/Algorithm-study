package ch01;

/*
    - 양의 정수를 입력하고 자릿수를 출력하는 프로그램
    ex) 135 -> 3자리, 1342 -> 4자리, -123 -> 양수를 입력하세요.
 */

import java.util.Scanner;

public class Practice10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("양의 정수를 입력하세요. : ");
        num = sc.nextInt();

        while (true) {
            if (num > 0)
                break;
            System.out.print("양의 정수를 입력하세요. : ");
            num = sc.nextInt();
        }

        int digits = 0;         // 자릿수
        while (num > 0) {
            num /= 10;         // n을 10으로 나눕니다
            digits++;
        }

        System.out.println("그 수는 " + digits + "자리입니다.");
    }
}
