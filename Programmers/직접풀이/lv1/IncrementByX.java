package lv1;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12954
    * x만큼 간격이 있는 n개의 숫자
    함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴
        - x는 -10,000,000 이상, 10,000,000 이하인 정수입니다.
        - n은 1,000 이하인 자연수
 */

import java.util.Arrays;

public class IncrementByX {

    long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = ((long) x) * (i + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int x = -4;
        int n = 2;
        IncrementByX incrementByX = new IncrementByX();
        System.out.println(Arrays.toString(incrementByX.solution(x, n)));

    }
}
