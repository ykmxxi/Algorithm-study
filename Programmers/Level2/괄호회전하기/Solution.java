package level2.괄호회전하기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/76502

    - 올바른 괄호 문자열
        - (), [], {} -> 모두 올바른 괄호 문자열
        - 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열
            ex) [] 가 올바른 괄호 문자열이라면 ([]), [[]], {[]} 도 올바른 괄호 문자열
        - 만약 A, B가 올바른 괄호 문자열이라면 AB도 올바른 괄호 문자열
            ex) [], ({}) 가 올바른 괄호 문자열이라면 []({}) 도 올바른 괄호 문자열
*/

import java.util.Stack;

class Solution {

	static boolean check(String str) {
		Stack<Character> stack = new Stack<>();
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (cnt < 0) { // 가지치기, 닫는 괄호가 더 많이 나오면 바로 종료
				return false;
			}

			if (ch == '(' || ch == '{' || ch == '[') {
				cnt++;
			} else {
				cnt--;
			}

			if (stack.isEmpty()) {
				stack.push(ch);
				continue;
			}

			if (ch == ')' && stack.peek() == '(') {
				stack.pop();
				continue;
			}

			if (ch == ']' && stack.peek() == '[') {
				stack.pop();
				continue;
			}

			if (ch == '}' && stack.peek() == '{') {
				stack.pop();
				continue;
			}

			stack.push(ch);
		}

		return stack.size() == 0;
	}

	public int solution(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(i).concat(s.substring(0, i));

			if (check(str)) {
				answer++;
			}
		}

		return answer;
	}
}
