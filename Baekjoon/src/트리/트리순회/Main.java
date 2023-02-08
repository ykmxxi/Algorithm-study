package 트리.트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static ArrayList<Character>[] adj; // 노드, 왼쪽 자식, 오른쪽 자식

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int index = st.nextToken().charAt(0) - 'A';
			for (int j = 1; j < 3; j++) {
				adj[index].add(st.nextToken().charAt(0));
			}
		}
	}

	static void preorder(Character x) { // 루트 -> 왼쪽 자식 -> 오른쪽 자식
		if (x.equals('.')) {
			return;
		}
		sb.append(x);
		preorder(adj[x - 'A'].get(0));
		preorder(adj[x - 'A'].get(1));
	}

	static void inorder(Character x) { // 왼쪽 자식 -> 루트 -> 오른쪽 자식
		if (x.equals('.')) {
			return;
		}
		inorder(adj[x - 'A'].get(0));
		sb.append(x);
		inorder(adj[x - 'A'].get(1));
	}

	static void postorder(Character x) { // 왼쪽 자식 -> 오른쪽 자식 -> 루트
		if (x.equals('.')) {
			return;
		}
		postorder(adj[x - 'A'].get(0));
		postorder(adj[x - 'A'].get(1));
		sb.append(x);
	}

	static void pro() {
		// 전위 순회
		preorder('A');
		sb.append('\n');

		// 중위 순회
		inorder('A');
		sb.append('\n');

		// 후위 순회
		postorder('A');
		sb.append('\n');

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
