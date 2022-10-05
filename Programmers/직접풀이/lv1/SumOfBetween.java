package lv1self;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12912
    * 두 정수 사이의 합
    두 정수 a, b가 주어졌을 때 a 와 b 사이에 속한 모든 정수의 합을 리턴하는 함수
    ex) a = 3, b = 5 -> 3 + 4 + 5 = 12
        - a 와 b가 같은 경우는 둘 중 아무 수나 return
        - a 와 b는 -10,000,000 이상 10,000,000 이하인 정수
        - a 와 b의 대소관계는 정해져있지 않음
 */

public class SumOfBetween {

    long solution(int a, int b) {

        long answer = 0;

        if (a > b) {
            for (int i = b; i <= a; i++) {
                answer += i;
            }
        } else if (a < b) {
            for (int i = a; i <= b; i++) {
                answer += i;
            }

        } else {
            answer = a;
        }
        return answer;

    }

    public static void main(String[] args) {

        SumOfBetween sumOfBetween = new SumOfBetween();
        System.out.println(sumOfBetween.solution(3,5));
        System.out.println(sumOfBetween.solution(5,3));
        System.out.println(sumOfBetween.solution(3,3));
        System.out.println(sumOfBetween.solution(-10,11));
        System.out.println(sumOfBetween.solution(-5,0));

    }
}

