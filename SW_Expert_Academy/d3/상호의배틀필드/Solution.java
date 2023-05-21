package d3.상호의배틀필드;

/*
	# 1873. 상호의 배틀필드

	- 사용자의 전차는 입력에 따라 격자판으로 이루어진 게임 맵에서 다양한 동작을 한다
		.	평지(전차가 들어갈 수 있다.)
		*	벽돌로 만들어진 벽
		#	강철로 만들어진 벽
		-	물(전차는 들어갈 수 없다.)
		^	위쪽을 바라보는 전차(아래는 평지이다.)
		v	아래쪽을 바라보는 전차(아래는 평지이다.)
		<	왼쪽을 바라보는 전차(아래는 평지이다.)
		>	오른쪽을 바라보는 전차(아래는 평지이다.)
	- 입력
		U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
		D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
		L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
		R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
		S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
	- 포탄을 발사했을 때 벽돌 벽이면 평지가 되고, 강철 벽이면 아무런 일도 일어나지 않는다
	- 초기 맵 상태가 주어지고 사용자의 입력이 주어질 때 모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지

	## 입력
	- 테케의 수 T
	- 각 테케 첫째 줄: H W
		- 2 <= H, W <= 20
		- H: 게임 맵의 높이(행), W: 게임 맵의 너비(열)
	- 다음 H개의 줄에 길이가 W인 문자열이 주어짐
		전차는 한개
	- 다음 줄: N
		- 명령의 개수, 0 < N <= 100
	- 다음 줄: 길이가 N인 문자열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int H, W, N, x, y; // x: 탱크의 현재 x좌표, y: 탱크의 현재 y좌표
	static char[][] map;
	static String orders;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '<') {
					x = i;
					y = j;
				}
			}
		}

		N = Integer.parseInt(br.readLine());
		orders = br.readLine();
	}

	static void shoot() {
		char dir = map[x][y];

		if (dir == '^') {
			for (int i = x; i >= 0; i--) {
				if (i == x) {
					continue;
				}
				if (map[i][y] == '.' || map[i][y] == '-') { // 평지 or 물 이면 넘어가기
					continue;
				}
				if (map[i][y] == '#') { // 강철로 만든 벽이면 아무일도 일어나지 않는다
					break;
				}
				if (map[i][y] == '*') {
					map[i][y] = '.';
					break;
				}
			}
		}
		if (dir == '>') {
			for (int i = y; i < W; i++) {
				if (i == y) {
					continue;
				}
				if (map[x][i] == '.' || map[x][i] == '-') { // 평지 or 물 이면 넘어가기
					continue;
				}
				if (map[x][i] == '#') { // 강철로 만든 벽이면 아무일도 일어나지 않는다
					break;
				}
				if (map[x][i] == '*') {
					map[x][i] = '.';
					break;
				}
			}

		}
		if (dir == 'v') {
			for (int i = x; i < H; i++) {
				if (i == x) {
					continue;
				}
				if (map[i][y] == '.' || map[i][y] == '-') { // 평지 or 물 이면 넘어가기
					continue;
				}
				if (map[i][y] == '#') { // 강철로 만든 벽이면 아무일도 일어나지 않는다
					break;
				}
				if (map[i][y] == '*') {
					map[i][y] = '.';
					break;
				}
			}

		}
		if (dir == '<') {
			for (int i = y; i >= 0; i--) {
				if (i == y) {
					continue;
				}
				if (map[x][i] == '.' || map[x][i] == '-') { // 평지 or 물 이면 넘어가기
					continue;
				}
				if (map[x][i] == '#') { // 강철로 만든 벽이면 아무일도 일어나지 않는다
					break;
				}
				if (map[x][i] == '*') {
					map[x][i] = '.';
					break;
				}
			}
		}
	}

	static void move(char order) {
		if (order == 'U') {
			map[x][y] = '^';
			int nx = x - 1;
			int ny = y;

			if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') {
				map[nx][ny] = '^';
				map[x][y] = '.';
				x = nx;
				y = ny;
			}
		}
		if (order == 'D') {
			map[x][y] = 'v';
			int nx = x + 1;
			int ny = y;

			if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') {
				map[nx][ny] = 'v';
				map[x][y] = '.';
				x = nx;
				y = ny;
			}
		}
		if (order == 'L') {
			map[x][y] = '<';
			int nx = x;
			int ny = y - 1;

			if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') {
				map[nx][ny] = '<';
				map[x][y] = '.';
				x = nx;
				y = ny;
			}
		}
		if (order == 'R') {
			map[x][y] = '>';
			int nx = x;
			int ny = y + 1;

			if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') {
				map[nx][ny] = '>';
				map[x][y] = '.';
				x = nx;
				y = ny;
			}
		}
	}

	static void play(char order) {
		if (order == 'S') {
			shoot();
		} else {
			move(order);
		}
	}

	static void pro(int tc) {
		for (int i = 0; i < N; i++) {
			char order = orders.charAt(i);

			play(order);
		}

		sb.append('#').append(tc).append(' ');
		for (char[] arr : map) {
			for (char ch : arr) {
				sb.append(ch);
			}
			sb.append('\n');
		}
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			input();
			pro(i);
		}

		System.out.print(sb);
	}

}
