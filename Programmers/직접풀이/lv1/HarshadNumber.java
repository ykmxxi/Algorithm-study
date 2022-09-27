package lv1;
/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12947
    * 하샤드 수
    양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를들어 18의 자릿수 합은
    1 + 8 = 9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수
        - x는 1 이상, 10,000 이하인 정수
 */

import java.util.*;

public class HarshadNumber {

    boolean solution(int x) {
        boolean answer = true;
        int sumOfDigits = 0;
        int temp = x;

        while (temp != 0) {
            sumOfDigits += temp % 10;
            temp /= 10;
        }

        if (x % sumOfDigits == 0) {
            answer = true;
        } else
            answer = false;

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        HarshadNumber harshadNumber = new HarshadNumber();
        System.out.println(harshadNumber.solution(x));

    }
}
