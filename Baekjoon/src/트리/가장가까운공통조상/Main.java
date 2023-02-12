package 트리.가장가까운공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, A, B;
	static int[] parent;
	static boolean[] check;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		check = new boolean[N + 1];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			parent[y] = x;
		}

		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}

	static void pro() {
		int x = A;
		int y = B;

		while (x > 0) { // 루트 노드까지 A의 조상들을 check
			check[x] = true;
			x = parent[x];
		}

		while (y > 0 && !check[y]) { // B의 조상들을 확인, A의 조상들을 탐색하면 check 된 부분을 만나면 stop
			y = parent[y];
		}

		sb.append(y).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			T--;
			input();
			pro();
		}

		System.out.println(sb);
	}
}
