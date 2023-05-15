package d2.백만장자프로젝트;

/*
	# 1859 백만 장자 프로젝트

	- 다음 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 한다
		1. 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다
		2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다
		3. 판매는 얼마든지 할 수 있다
	- 예를 들어 3일 동안의 매매가가 [1, 2, 3] 이라면 처음 두 날에 원료를 구매해 마지막 날에 팔면 3의 이익
		- 매입: 1 + 2, 매매: 2 * 3, 이익: 6 - 3 = 3
 */

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int T, N;
	static int[] prices, visit;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		prices = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		visit = new int[N];
	}

	static void pro(int tc) {
		long profit = 0L;
		int max = prices[N - 1];

		for (int i = N - 2; i >= 0; i--) {
			if (max > prices[i]) {
				profit += max - prices[i];
			} else {
				max = prices[i];
			}
		}

		sb.append('#').append(tc).append(' ').append(profit).append('\n');
	}

	public static void main(String[] args) throws IOException {
		// 첫째 줄: 테스트 케이스
		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			input();
			pro(i);
		}

		System.out.print(sb);
	}

}
