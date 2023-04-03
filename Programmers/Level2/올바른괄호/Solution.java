package level2.올바른괄호;

/* https://school.programmers.co.kr/learn/courses/30/lessons/12909
    - 괄호가 바르게 짝지어졌다: '(' 로 열렸으면 ')'로 닫혀야 한다
        "()()" 또는 "(())()": 올바름
        ")()(" 또는 "(()(": 올바르지 않음
    - 큐에 넣었을 때
        올바름: 1-11-1, 11-1-11-1
        올바르지 않음: -11-11, 11-11
    - 올바르지 않은 괄호
        짝을 지었을 때 개수가 안 맞음: cnt != 0
        -1(닫는 괄호로 시작)로 시작, cnt < 0

*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	boolean solution(String s) {
		boolean answer = true;
		int cnt = 0;

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { // 여는 괄호는 1
				q.add(1);
			} else { // 닫는 괄호는 -1
				q.add(-1);
			}
		}

		while (!q.isEmpty()) {
			cnt += q.poll();

			if (cnt < 0) { // 중간에 음수가 되면 닫는 괄호가 먼저 나온 상황
				answer = false;
				break;
			}
		}

		if (cnt != 0) { // 짝이 맞지 않으면 잘못된 괄호
			answer = false;
		}

		return answer;
	}
}
