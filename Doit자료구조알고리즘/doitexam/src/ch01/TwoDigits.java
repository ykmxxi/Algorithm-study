package ch01;

import java.util.Scanner;

public class TwoDigits {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int no;

        System.out.println("2자리 양수를 입력하시오.");

        do {
            System.out.print("no 값 : ");
            no = sc.nextInt();
        } //while(no < 10 || no > 99);
        // 드모르간 법칙
        while (!(no >= 10 && no <= 99));

        System.out.println("변수 no 값은 " + no + "이 되었습니다.");
    }
}
