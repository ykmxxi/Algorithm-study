package ch01;

import java.util.Scanner;

/*
    p.42 Do it 실습 1-15
    * 를 n개 출력하되 w개 마다 줄 바꿈을 하는 프로그램
*/
public class PrintStars2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, w;

        System.out.println("*를 n개 출력하되 w개 마다 줄을 바꿔서 출력.");

        do {
            System.out.print("n 값 : ");
            n = sc.nextInt();
        } while (n <= 0);

        do {
            System.out.print("w 값 : ");
            w = sc.nextInt();
        } while (w <= 0 || w > n);

        /*
            repeat() : String 클래스에 들어 있는 인스턴스 메서드
            ex) "ABC".repeat(3) -> "ABCABCABC"
        */
        for (int i = 0; i < n / w; i++) {
            System.out.println("*".repeat(w));
        }

        int rest = n % w;
        if (rest != 0) {
            System.out.println("*".repeat(rest));
        }
    }
}
