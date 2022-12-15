package lv1self.수박;


/*

    https://school.programmers.co.kr/learn/courses/30/lessons/12922
    * 수박수박수박수박수박수?
        길이가 n 이고, "수박수박수박수..."와 같은 패턴을 유지하는 문자열을 리턴하는 함수
        예를들어, n 이 4 이면 "수박수박", 3 이면 "수박수"

            * 제한 조건
            - n 은 길이 10,000 이하인 자연수

 */

import java.util.Scanner;

public class Lv1_12922 {

    String solution(int n) {
        StringBuilder answer = new StringBuilder();

        if (n % 2 == 1) {    // 홀수
            for (int i = 0; i < n / 2; i++) {
                answer.append("수박");
            }
            answer.append("수");

        } else {    // 짝수
            for (int i = 0; i < n / 2; i++) {
                answer.append("수박");
            }

        }

        return answer.toString();
    }

    public static void main(String[] args) {

        int n;
        Scanner scanner = new Scanner(System.in);
        Lv1_12922 lv1_12922 = new Lv1_12922();

        do {
            System.out.println("n 을 입력 (10,000 이하 자연수)");
            n = scanner.nextInt();
            System.out.println(lv1_12922.solution(n));

        } while (n != 0);

        System.out.println("종료");


    }
}
