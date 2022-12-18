package lv1self.최대공약수최소공배수;
/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12940
    프로그래머스 Lv1 12940번: 최대공약수와 최소공배수
 */

public class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = getGreatestCommonDivisor(n, m);
        answer[1] = getLeastCommonMultiple(n, m);

        return answer;
    }

    public static int getGreatestCommonDivisor(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return getGreatestCommonDivisor(m, n % m);
    }

    public static int getLeastCommonMultiple(int n, int m) {
        return n * m / getGreatestCommonDivisor(n, m);
    }
}
