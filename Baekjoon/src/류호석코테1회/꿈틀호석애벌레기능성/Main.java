package 류호석코테1회.꿈틀호석애벌레기능성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K, ans;
	static int[] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

	}

	static void dfs(int idx, int energy) {
		ans = Math.max(ans, energy);

		int sum = 0;
		for (int i = idx; i <= N; i++) {
			sum += A[i];
			if (sum >= K) { // idx 번 부터 연속적으로 먹었을 때 K보다 커지면
				dfs(i + 1, energy + (sum - K)); // 누적된 탈피 에너지값을 저장하고 구간을 땡겨서 탐색
				break;
			}

			dfs(idx + 1, energy); // 1번 부터 N번 까지 각각 1개만 먹었을 때 탐색
		}
	}

	static void pro() {
		dfs(1, 0);
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
