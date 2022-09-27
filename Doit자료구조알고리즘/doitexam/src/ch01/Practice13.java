package ch01;

/*
    p.46 연습문제 13
    변의 길이를 입력받아 해당 길이의 정사각형을 *로 출력
 */

import java.util.Scanner;

public class Practice13 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = 0;

        System.out.println("정사각형을 출력합니다.");
        System.out.print("변의 길이 : ");
        length = sc.nextInt();


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /*
        for(int i = 0; i < length; i++) {
            System.out.println("*".repeat(length));
        }
         */
    }
}
