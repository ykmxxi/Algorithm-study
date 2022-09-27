package ch01;

import java.util.Scanner;

// while 문으로 1 부터 n 까지 숫자의 합 구하기

public class SumWhile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 n 까지의 합을 구합니다.");
        System.out.print("n : ");
        int n = sc.nextInt();

        int i = 1;
        int total = 0;
        while (i <= n) {
            total += i;
            i++;
        }

        System.out.println("1 부터 " + n + " 까지의 합은 " + total);

    }
}
