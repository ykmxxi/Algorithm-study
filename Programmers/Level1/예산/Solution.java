package lv1self.예산;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12982
    - 프로그래머스 Lv1 12982번: 예산
        - 예산이 한정되어 있기 때문에, 최대한 많은 부서를 지원해야 함
        - 선정된 부서의 신청금액 전액을 지원해야 함
        - 배열 d는 부서별로 신청한 금액이 들어있는 배열, 전체 부서의 개수는 1 이상 100 이하
        - d의 각 원소는 부서별로 신청한 금액, 금액은 1 이상 100,000 이하의 자연수
        - budget은 예산, 1 이상 10,000,000 이하의 자연수
        - Ex: d = [1, 3, 2, 5, 4], budget = 9, result = 3(3개 부서)
 */

import java.util.Arrays;

public class Solution {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        int total = 0;
        Arrays.sort(d);

        for (int amount : d) {
            total += amount;
            if (total <= budget) {
                answer += 1;
            } else {
                break;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        System.out.println(solution(d, 9));
    }
}
