package ch01;

import java.util.Scanner;

/*
    p.49 연습문제 15
    n단의 피라미드를 출력하는 메서드를 작성
 */
public class Practice15 {

    static void spira(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.printf("%d", i+1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0;

        System.out.println("n단의 피라미드를 출력합니다.");
        do {
            System.out.print("n 값 : ");
            n = sc.nextInt();
        } while (n <= 0);
        spira(n);

    }
}
