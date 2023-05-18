package d3.string;

/*
	1213. String

	- 주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램
	- 총 10개의 테케가 주어짐
	- 문장의 길이는 1000자 이하
	- 한 문장에서 검색하는 문자열의 길이는 최대 10

	## 입력
	- 각 테케 첫째 줄: 테케 번호
	- 각 테케 둘째 줄: 찾을 문자열
	- 각 테케
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int tc;
	static String find, input;

	static void input() throws IOException {
		tc = Integer.parseInt(br.readLine());
		find = br.readLine();
		input = br.readLine();
	}

	static void pro() {
		int answer = 0;

		// 1. 찾을 문자열의 첫 번째 문자
		char first = find.charAt(0);
		int len = find.length();

		// 2. 순회
		for (int i = 0; i <= input.length() - len; i++) {
			if (input.charAt(i) == first) {
				if (input.substring(i, i + len).equals(find)) {
					answer++;
				}
			}
		}

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			input();
			pro();
		}

		System.out.print(sb);
	}

}
