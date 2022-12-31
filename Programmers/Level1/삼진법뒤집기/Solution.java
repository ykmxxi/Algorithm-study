package lv1self.삼진법뒤집기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/68935
    - 프로그래머스 Lv1 68935번: 3진법 뒤집기
        - 자연수 n이 매개변수로 주어짐
        - n을 3진법 상에서 앞뒤로 뒤집은 후 10진법으로 표현
        - Ex: 45 -> 1200 -> 0021 -> 7
 */
public class Solution {
    public static int solution(int n) {
        int answer = 0;
        long ternary = 0L;
        long reverse = 0L;
        long digit = 1L;

        // 3진수로 변환
        do {
            ternary += (n % 3) * digit;
            n /= 3;
            digit *= 10;
        } while (n != 0);

        // 뒤집기
        while (ternary != 0) {
            reverse = reverse * 10 + ternary % 10;
            ternary /= 10;
        }

        // 10진수로 변환
        digit = 1L;
        do {
            answer += (reverse % 10) * digit;
            reverse /= 10;
            digit *= 3;

        } while (reverse != 0);

        return answer;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }
}

