package lv1;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12931
    * 자릿수 더하기
    자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 Return 하는 함수
    ex) N = 123, 1 + 2 + 3 = 6
        - N의 범위 : 100,000,000 이하의 자연수
 */

public class SumOfDigits {

    int solution(int n) {
        int answer = 0;

        while (true) {
            answer += n % 10;
            n /= 10;
            if (n == 0)
                break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 123;
        SumOfDigits sumOfDigits = new SumOfDigits();
        System.out.println(sumOfDigits.solution(n));

    }
}
