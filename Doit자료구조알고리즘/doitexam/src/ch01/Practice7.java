package ch01;

import java.util.Scanner;

public class Practice7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("n : ");
        int n = sc.nextInt();

        int sum = 0;
        if (n % 2 == 0) {
            sum = (1 + n) * (n/2);
        } else {
            sum = (1 + n) * (n/2) + (1+n)/2;
        }

        System.out.printf("정답 : %d", sum);
    }
}
