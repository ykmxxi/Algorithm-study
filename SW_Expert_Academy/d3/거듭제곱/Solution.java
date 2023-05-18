package d3.거듭제곱;

/*
	# 1217. 거듭 제곱

	- N M 이 주어질 때 N의 거듭제곱 값을 재귀호출을 이용해 구하기
	- 총 10개의 테케
	- Integer 범위를 넘지 않음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int tc, N, M;

	static void input() throws IOException {
		tc = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

	static int rec_func(int k) {
		if (k == 0) {
			return 1;
		}
		if (k == 1) {
			return N;
		}

		return N * rec_func(k - 1);
	}

	static void pro() {
		int answer = rec_func(M);

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
