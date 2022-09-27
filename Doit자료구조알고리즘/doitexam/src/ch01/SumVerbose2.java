package ch01;

import java.util.Scanner;

public class SumVerbose2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; // 입력받을 수

        System.out.println("1 부터 n 까지의 합을 구합니다.");

        int sum = 0;
        n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            System.out.print(i + " + ");
            sum += i;
        }
        System.out.print(n + " = ");
        sum += n;
        System.out.println(sum);
    }
}
