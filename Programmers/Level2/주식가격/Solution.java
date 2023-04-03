package level2.주식가격;

/* https://school.programmers.co.kr/learn/courses/30/lessons/42584
    - 초 단위로 기록된 주식가격이 담긴 배열이 주어졌을 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return
    - 주어진 데이터의 크기가 100,000일 때 이중 반복문을 통한 완전탐색은 10^10(100억), 약 100초가 걸림
*/

import java.util.*;

public class Solution {
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // 현재 가격이 스택에 있는 가격보다 낮으면
				answer[stack.peek()] = i - stack.peek(); // 스택에 저장된 초(인덱스)의 가격은 i - 스택에 저장된 초 만큼 가격이 떨어지지 않았음
				stack.pop(); // 스택에서 제거
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) { // 스택에 남아있는 초(인덱스)들 처리
			answer[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3})));
	}
}
