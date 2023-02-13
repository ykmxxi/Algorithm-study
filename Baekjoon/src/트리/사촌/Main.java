package 트리.사촌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, k;
	static int[] info, parent;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if (n == 0 && k == 0) {
			return;
		}

		info = new int[n + 1];
		parent = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		// tree 생성
		parent[0] = -1;
		parent[1] = 0; // 첫번 째 정점(루트 노드)의 부모는 0

		// 부모 노드 설정
		int last = 1; // 자식을 갖는 노드들 중 마지막에 자식이 추가된 노드
		for (int i = 2; i <= n; i++, last++) {
			for (; i <= n; i++) { // i번 부터 연속한 수를 가진 정점을 모두 last 의 자식으로 묶는다.
				parent[i] = last;
				if (i < n && info[i] + 1 != info[i + 1]) {
					break;
				}
			}
		}

		// k의 사촌 찾기: 부모의 형제들의 자식 노드들의 수
		// k의 인덱스 찾기
		int kIndex = 0;
		for (int i = 1; i <= n; i++) {
			if (info[i] == k) {
				kIndex = i;
				break;
			}
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (parent[parent[i]] == parent[parent[kIndex]] && parent[i] != parent[kIndex]) {
				answer++;
			}
		}
		sb.append(answer).append('\n');

	}

	public static void main(String[] args) throws IOException {
		while (true) {
			input();
			if (n == 0 && k == 0) {
				break;
			}
			pro();
		}
		System.out.println(sb);
	}
}
