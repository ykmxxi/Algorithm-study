package 트리.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, root, erased; // 노드의 개수, root node, 지울 노드
	static ArrayList<Integer>[] child;
	static int[] leaf;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		child = new ArrayList[N];
		leaf = new int[N];

		for (int i = 0; i < N; i++) {
			child[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			if (node == -1) {
				root = i;
				continue;
			}
			child[node].add(i);
		}

		erased = Integer.parseInt(br.readLine());
	}

	// 정점 x 의 부모가 par 이고, subtree(x)의 leaf node 개수를 세는 역할
	static void dfs(int x, int par) {
		if (child[x].isEmpty()) {
			leaf[x] = 1;
		}

		for (int y : child[x]) {
			if (y == par) {
				continue;
			}
			dfs(y, x);
			leaf[x] += leaf[y];
		}
	}

	static void pro() {
		// 입력받은 노드를 제거(부모와 연결을 끊어주기)
		for (int i = 0; i < N; i++) {
			if (child[i].contains(erased)) {
				child[i].remove(child[i].indexOf(erased));
			}
		}

		// erased 가 root 인 예외 처리
		if (root != erased) {
			dfs(root, -1);
		}

		System.out.println(leaf[root]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
