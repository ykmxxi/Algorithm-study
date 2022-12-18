package lv1self.부족한금액계산;
/*
    https://school.programmers.co.kr/learn/courses/30/lessons/82612
    프로그래머스 Lv1 82612번: 부족한 금액 계산하기
 */

class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;

        for (int i = 1; i <= count; i++) {
            answer -= (long) price * i;
        }

        if (answer < 0) {
            return Math.abs(answer);
        } else {
            return 0L;
        }
    }
}
