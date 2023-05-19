package d2.지그재그숫자;

/*
	# 1986. 지그재그 숫자
	- 1 부터 N까지의 숫자에서 홀수는 더하고 짝수는 뺐을 때 최종 누적된 값
	- 예시: N = 5, 1 - 2 + 3 - 4 + 5 = 3
	- 1 <= N <= 10

	## 입력
	- 첫째 줄: 테케 개수 T
	- 각 테케에는 N이 주어짐

	## 출력
	- #t 정답

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void preprocess() {
		dy = new int[11];

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) { // 짝수이면 뺀다
				dy[i] = dy[i - 1] - i;
			} else { // 홀수이면 더한다
				dy[i] = dy[i - 1] + i;
			}
		}
	}

	static void pro(int tc) {
		sb.append('#').append(tc).append(' ').append(dy[N]).append('\n');
	}

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		preprocess();

		for (int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}

		System.out.print(sb);
	}

}
