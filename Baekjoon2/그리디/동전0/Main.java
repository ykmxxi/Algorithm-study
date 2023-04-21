package 그리디.동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static Integer[] coins;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		coins = new Integer[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
	}

	static void pro() {
		// 동전을 큰 순서대로 정렬 (내림차순)
		Arrays.sort(coins, Collections.reverseOrder());
		int answer = 0;

		while (K > 0) {
			for (Integer coin : coins) {
				if (K / coin == 0) {
					continue;
				}

				int cnt = K / coin;
				answer += cnt;
				K -= cnt * coin;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
