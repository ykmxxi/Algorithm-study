package ch02;
// 10진수 정수값을 n진수로 변환하는 예제

import java.util.Scanner;

public class CardConv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number; // 변환하는 정수
        int cd; // 기수
        int dno; // 변환 후 자리수
        int retry; // 재 반복
        char[] cno = new char[32];

        System.out.println("10진수를 n진수로 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수: ");
                number = scanner.nextInt();
            } while (number < 0);

            do {
                System.out.print("2 ~ 36 진수로 변환 가능, 변환할 기수값을 입력하세요: ");
                cd = scanner.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConv(number, cd, cno);

            for (int i = 0; i < dno; i++) {
                System.out.print(cno[i]);
            }

            System.out.println("\n한 번더 진행?(1:예, 2:아니요)");
            retry = scanner.nextInt();
        } while (retry == 1);


    }

    public static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = t;
        }

        return digits;
    }
}
