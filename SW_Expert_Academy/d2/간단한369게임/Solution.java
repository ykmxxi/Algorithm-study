package d2.간단한369게임;

/*
	# 1926 간단한 369게임

	- 게임 규칙
		1. 숫자 1부터 순서대로 차례대로 말하되, "3", "6", "9"가 들어가 있는 수는 말하지 않는다
		2. 말하지 않는 대신 박수를 친다. 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다
			35: "-"
			36: "--"
	- 입력으로 정수 N이 주어졌을 때 1 ~ N 까지 게임 규칙에 맞게 출력
		- 10 <= N <= 1,000
		- 각 숫자는 공백으로 구분하고, 박수를 2번 이상 칠때는 이어 붙인다
		- ex: N = 10, "1 2 - 4 5 - 7 9 - 10"
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static String clap(String num) {
		StringBuilder builder = new StringBuilder();
		int cnt = 0;

		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);

			if (ch == '3' || ch == '6' || ch == '9') {
				cnt++;
			}
		}

		while (cnt-- > 0) {
			builder.append('-');
		}

		return builder.toString();
	}

	static void pro() {
		// 1. 1부터 N을 순회한다
		for (int i = 1; i <= N; i++) {
			String num = Integer.toString(i);

			// 2. 3 6 9 가 들어가는지 확인
			if (num.contains("3") || num.contains("6") || num.contains("9")) {
				// 3. 3, 6, 9가 포함되어 있으면 박수 횟수를 체크
				sb.append(clap(num)).append(' ');
			} else { // 4. 포함되어 있지 않으면 숫자를 그대로 출력
				sb.append(num).append(' ');
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
