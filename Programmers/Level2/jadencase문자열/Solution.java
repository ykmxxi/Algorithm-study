package level2.jadencase문자열;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12951

    JadenCase: 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열
    단 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자
*/

import java.util.StringTokenizer;

class Solution {
	public String solution(String s) {
		s = s.toLowerCase(); // 모든 문자를 소문자로 변경

		StringTokenizer st = new StringTokenizer(s, " ", true); // 공백으로 구분하고, 구분자도 포함
		StringBuilder sb = new StringBuilder();

		while (st.hasMoreTokens()) {
			String token = st.nextToken();

			if (token.equals(" ")) { // 공백이면
				sb.append(token); // 그대로 붙이기
			} else { // 공백이 아니면
				sb.append(token.substring(0, 1).toUpperCase().concat(token.substring(1))); // 첫 문자만 대문자로 바꿔서 붙이기
			}
		}

		return sb.toString();
	}
}
