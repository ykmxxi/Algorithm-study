package ch01;

import java.util.Scanner;

public class SumFor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("1 부터 n 까지의 합을 구합니다.");
        System.out.print("n : ");
        int n = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= n; i++) {
            total += i;
        }

        System.out.println("1 부터 " + n + " 까지의 합은 " + total);

    }
}
