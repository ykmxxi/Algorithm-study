package ch01;

/*
    p.39 Do it 실습 1-13
    + 와 - 를 번갈아 출력
 */

import java.util.Scanner;

public class Alternative2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("+ 와 - 를 번갈아 n개 출력.");
        System.out.print("n 값 : ");
        n = sc.nextInt();

        for (int i = 0; i < n / 2; i++) {
            System.out.print("+-");
        }
        if (n % 2 != 0) {
            System.out.print("+");
        }
    }
}
