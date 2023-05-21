package d3.햄버거다이어트;

/*
	# 5215. 햄버거 다이어트

	- 햄버거의 맛은 최대한 유지하며 정해진 칼로리를 넘지 않는 햄버거를 주문해 먹는다
	- 조합에 들어가는 재료를 잘라서 조합해주지 않고 재료를 선택하면 그대로 사용해 조합
	- 재료에 대한 맛을 점수로 매겨놓음
	- 좋아하는 햄버거를 먹으며 정해진 칼로리 이하의 조합 중 가장 선호하는 햄버거를 조합
	- 같은 재료는 여러 번 X

	## 입력
	- 첫째 줄: 총 테케 수 T
	- 각 테케 첫째 줄: 재료의 수(N), L(제한 칼로리)
		- 1 <= N <= 20
		- 1 <= L <= 10^4(10,000)
	- 각 테케 둘째 줄부터 N개의 줄에 걸쳐 재료의 점수, 칼로리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, L, max;
	static int[] selected, used;
	static Info[] infos;

	static class Info {
		int score;
		int cal;

		public Info(int score, int cal) {
			this.score = score;
			this.cal = cal;
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		infos = new Info[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			infos[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}

	static void rec_func(int target, int depth, int totalCal) {
		if (depth == target) {
			int score = 0;

			for (int idx : selected) {
				score += infos[idx].score;
			}

			max = Math.max(score, max);

		} else {
			int start;
			if (depth == 0) {
				start = -1;
			} else {
				start = selected[depth - 1];
			}
			for (int i = start + 1; i < N; i++) {
				totalCal += infos[i].cal;
				if (totalCal > L) {
					totalCal -= infos[i].cal;
					continue;
				}
				selected[depth] = i;

				rec_func(target, depth + 1, totalCal);

				totalCal -= infos[i].cal;
				selected[depth] = 0;
			}
		}
	}

	static void pro(int tc) {
		max = 0;

		for (int i = 1; i <= N; i++) {
			selected = new int[i];
			used = new int[N];
			rec_func(i, 0, 0);
		}

		sb.append('#').append(tc).append(' ').append(max).append('\n');
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
