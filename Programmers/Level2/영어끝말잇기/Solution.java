package level2.영어끝말잇기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12981

    - 1 부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기 진행
    - 끝말잇기 규칙
        1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말한다
        2. 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작
        3. 앞사람이 말한 단어의 마지막 문자로 시작하는 던어를 말해야 함
        4. 이전에 등장했던 단어는 사용할 수 없음
        5. 한 글자인 단어는 인정되지 않음
    - ex) tank -> kick -> know -> wheel -> land -> dream -> mother -> robot -> tank
    - words(순서대로 말한 단어)가 주어질 때 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에서 탈락하는지
*/

import java.util.Stack;

class Solution {

	public int[] solution(int n, String[] words) {
		int[] answer = new int[2]; // answer[0]: 탈락한 사람의 번호, answer[1]: 몇 번째 차례에 탈락하는지
		Stack<String> stack = new Stack<>();
		stack.push(words[0]);

		for (int i = 1; i < words.length; i++) {
			String before = stack.peek();
			char end = before.charAt(before.length() - 1);
			char begin = words[i].charAt(0);

			if (stack.contains(words[i]) || end != begin) {
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}

			stack.push(words[i]);
		}

		return answer;
	}
}
