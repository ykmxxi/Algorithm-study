package level2.게임맵최단거리;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/1844

    (1, 1) 에서 (n, m) 까지의 최소 거리
    	1: 지나갈 수 있음
    	0: 벽(지나갈 수 없음)
    (n, m)까지 갈 수 없으면 -1을 return
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	static int bfs(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		int[][] dist = new int[n][m];
		int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

		Queue<Integer> q = new LinkedList<>();
		dist[0][0] = 1;
		q.add(0);
		q.add(0);

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) { // 범위를 벗어나거나
					continue;
				}

				if (dist[nx][ny] != 0) { // 이미 방문한 점이거나
					continue;
				}

				if (maps[nx][ny] == 0) { // 벽이면
					continue;
				}

				dist[nx][ny] = dist[x][y] + 1;
				q.add(nx);
				q.add(ny);
			}
		}

		return dist[n - 1][m - 1];
	}

	public int solution(int[][] maps) {
		// (1, 1) 에서 (n, m) 으로 갈 수 있는 최단 거리 구하기
		// bfs 결과가 0이면 도착점에 갈 수 없다는 뜻
		return bfs(maps) == 0 ? -1 : bfs(maps);
	}
}
