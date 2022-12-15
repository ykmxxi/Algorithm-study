package lv1self.짝수와홀수;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12937
    짝수와 홀수
    - 정수 num 이 짝수일 경우 "Even" 반환, 홀수인 경우 "Odd" 반환
    num -> int 범위 정수
    0 -> 짝수
 */

public class EvenOrOdd {

    String solution(int num) {
        String answer = "";

        if (num % 2 == 1 || num % 2 == -1) {
            answer = "Odd";
        } else {
            answer = "Even";
        }
        return answer;
    }

    public static void main(String[] args) {

        EvenOrOdd evenOrOdd = new EvenOrOdd();
        System.out.println(evenOrOdd.solution(3));
        System.out.println(evenOrOdd.solution(4));

    }
}
