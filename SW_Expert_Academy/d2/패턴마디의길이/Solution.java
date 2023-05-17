package d2.패턴마디의길이;

/*
	2007. 패턴 마디의 길이

	- 패턴에서 반복되는 부분을 마디라고 부른다
	- 문자열을 입력받아 마디의 길이를 출력하는 프로그램을 작성
	- 문자열의 길이는 30, 마디의 최대 길이는 10

	## 입력
	- 첫째 줄: 테스트 케이스의 개수 T
	- 0 각 테스트 케이스의 첫 번째 줄: 길이가 30인 문자열

	## 출력
	- #t 정답
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static String str;

	static void input() throws IOException {
		str = br.readLine();
	}

	static void pro(int tc) {
		int answer = 0;

		// 마디의 길이는 1 부터 10 까지
		for (int len = 1; len <= 10; len++) {
			if (str.substring(0, len).equals(str.substring(len, len * 2))) {
				answer = len;
				break;
			}
		}

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			input();
			pro(i);
		}

		System.out.print(sb);
	}

}
