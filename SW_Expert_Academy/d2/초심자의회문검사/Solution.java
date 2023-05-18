package d2.초심자의회문검사;

/*
	# 1989. 초심자의 회문 검사

	- "level" 처럼 거꾸로 읽어도 똑같으면 회문이라 한다
	- 단어를 입력받아 회문이면 1, 아니면 0을 출력하라
	- 각 단어의 길이는 3 이상 10 이하

	## 입력
	- 첫째 줄: 테케 개수 T
	- 각 테케마다 한 줄 씩 입력이 주어짐

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
		int answer = 1;
		int L = 0;
		int R = str.length() - 1;

		while (L <= R) {
			if (str.charAt(L) != str.charAt(R)) {
				answer = 0;
				break;
			}
			L++;
			R--;
		}
		/* StringBuffer 클래스의 reverse() 이용한 풀이

		StringBuffer buffer = new StringBuffer(str);
		if (buffer.reverse().toString().equals(str)) {
			answer = 1;
		} else {
			answer = 0;
		}

		 */

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}

		System.out.print(sb);
	}
}
