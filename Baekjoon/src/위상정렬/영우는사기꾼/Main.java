package 위상정렬.영우는사기꾼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, K;
	static ArrayList<Integer>[] adj;
	static int[] indeg, cnt, preBuildingCnt; // 들어오는 degree 의 개수 배열, 건물의 개수 배열, 선행 건물의 건설 여부

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		indeg = new int[N + 1];
		cnt = new int[N + 1];
		preBuildingCnt = new int[N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adj[x].add(y);
			indeg[y]++;
		}
	}

	static void pro() throws IOException {
		boolean cheat = false; // 치트키 사용 여부

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int buildOrDestroy = Integer.parseInt(st.nextToken());
			int buildingNum = Integer.parseInt(st.nextToken());

			if (buildOrDestroy == 1) { // 건설
				// 선행 건물이 건설되어 있나 확인
				// 건물의 indeg 보다 preBuildingCnt 이 작으면 선행 건물을 모두 건설한 것이 아님
				if (preBuildingCnt[buildingNum] < indeg[buildingNum]) {
					cheat = true;
				}

				cnt[buildingNum]++; // 건설

				if (cnt[buildingNum] == 1) { // 해당 건물을 처음 건설한 경우
					for (int y : adj[buildingNum]) {
						preBuildingCnt[y]++; // buildNum 이 선행인 건물들에 알려준다. 즉, y의 선행건물이 건설 완료되었다는 것을 알려줌
					}
				}

			} else { // 파괴
				if (cnt[buildingNum] == 0) { // 없는 건물을 파괴
					cheat = true;
				}

				cnt[buildingNum]--; // 파괴

				if (cnt[buildingNum] == 0) { // 건물이 모두 파괴 되었으면
					for (int y : adj[buildingNum]) {
						preBuildingCnt[y]--; // 해당 건물을 선행으로 하는 건물들에게 선행 건물이 없어졌다는 것을 알려준다.
					}
				}
			}
		}

		if (cheat) {
			System.out.println("Lier!");
		} else {
			System.out.println("King-God-Emperor");
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
