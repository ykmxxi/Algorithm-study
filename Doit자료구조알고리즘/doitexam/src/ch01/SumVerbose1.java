package ch01;

import java.util.Scanner;

// p.35 실습 1-10
public class SumVerbose1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; // 입력받을 수

        System.out.println("1 부터 n 까지의 합을 구합니다.");

        do {
            System.out.print("n 값 : ");
            n = sc.nextInt();
        } while (n <= 0);

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if (i < n) {
                System.out.print(i + " + ");
            } else {
                System.out.print(i + " = ");
            }
            sum += i;

        }
        System.out.println(sum);
    }
}
