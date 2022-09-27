package ch01;

import java.util.Scanner;

// 음수, 양수, 0 판독기
public class JudgeSign {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 입력하시오. : ");
        int num = sc.nextInt();

        if (num > 0) {
            System.out.println(num + "은 양수 입니다.");
        } else if (num < 0) {
            System.out.println(num + "은 음수 입니다.");
        } else
            System.out.println("이 수는 0 입니다.");
    }
}
