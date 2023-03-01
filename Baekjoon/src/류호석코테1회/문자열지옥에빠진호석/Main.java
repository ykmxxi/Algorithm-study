package 류호석코테1회.문자열지옥에빠진호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, K;
	static String[] A, kStr;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	static Map<String, Integer> map = new HashMap<String, Integer>();

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}

		kStr = new String[K];
		for (int i = 0; i < K; i++) {
			kStr[i] = br.readLine();
		}
	}

	static void dfs(int x, int y, String path, int len) {
		if (map.containsKey(path)) { // 이미 찾은 문자열이라면: 기존 경우의 수 + 1
			map.put(path, map.get(path) + 1);
		} else { // 처음 찾은 문자열이라면: 1
			map.put(path, 1);
		}

		if (len == 5) { // K의 최대길이는 5
			return;
		}

		for (int k = 0; k < 8; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx == -1) {
				nx += N;
			}
			if (nx == N) {
				nx -= N;
			}
			if (ny == -1) {
				ny += M;
			}
			if (ny == M) {
				ny -= M;
			}

			dfs(nx, ny, path + A[nx].charAt(ny), len + 1);
		}
	}

	static void pro() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, Character.toString(A[i].charAt(j)), 1);
			}
		}

		for (String K : kStr) {
			if (map.containsKey(K)) {
				sb.append(map.get(K));
			} else {
				sb.append(0);
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
