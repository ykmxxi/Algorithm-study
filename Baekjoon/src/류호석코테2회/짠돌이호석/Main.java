package 류호석코테2회.짠돌이호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N1, M1, N2, M2;
	static char[][] A, B, temp;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N1 = Integer.parseInt(st.nextToken());
		M1 = Integer.parseInt(st.nextToken());

		A = new char[Math.max(N1, M1) + 1][Math.max(N1, M1) + 1];
		for (int i = 1; i <= N1; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M1; j++) {
				A[i][j] = s.charAt(j - 1);
			}

		}

		st = new StringTokenizer(br.readLine(), " ");
		N2 = Integer.parseInt(st.nextToken());
		M2 = Integer.parseInt(st.nextToken());

		B = new char[Math.max(N2, M2) + 1][Math.max(N2, M2) + 1];
		for (int i = 1; i <= N2; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M2; j++) {
				B[i][j] = s.charAt(j - 1);
			}
		}
	}

	static void rotate() { // 2차원 배열 회전
		temp = new char[Math.max(N2, M2) + 1][Math.max(N2, M2) + 1];

		for (int i = 1; i <= N2; i++) { // 행
			for (int j = 1; j <= M2; j++) { // 열
				temp[j][N2 - i + 1] = B[i][j];
			}
		}

		// 회전 시 행과 열이 바뀜 (5 x 3) -> (3 x 5)
		int tmp = N2;
		N2 = M2;
		M2 = tmp;

		// 회전 시킨 배열을 원래 배열에 저장
		for (int i = 1; i <= N2; i++) {
			for (int j = 1; j <= M2; j++) {
				B[i][j] = temp[i][j];
			}
		}
	}

	static boolean possible(int shift_row, int shift_col) { // 평행 이동한 결과에서 겹치는 것이 존재하는지 확인하는 함수
		for (int ai = 1; ai <= N1; ai++) {
			for (int aj = 1; aj <= M1; aj++) {
				if (A[ai][aj] == '0') { // A[ai][aj]가 비어있는 격자이면 B[bi][bj]가 무조건 올 수 있음
					continue;
				}

				int bi = ai + shift_row; // 평행 이동한 행의 위치
				int bj = aj + shift_col; // 평행 이동한 열의 위치

				// 평행 이동한 위치가 격자를 벗어나지 않고
				// A[ai][aj]에 퍼즐이 있는 상태에서 B[bi][bj] 격자에 퍼즐이 있으면 겹치는 것이 존재
				if (1 <= bi && bi <= N2 && 1 <= bj && bj <= M2 && B[bi][bj] == '1') {
					return false;
				}
			}
		}

		return true;
	}

	static void pro() {
		int answer = Integer.MAX_VALUE;
		for (int r = 1; r <= 4; r++) { // B 배열을 4번 회전
			rotate(); // 회전

			for (int shift_row = -51; shift_row <= 51; shift_row++) { // 모든 x 축 평행 이동
				for (int shift_col = -51; shift_col <= 51; shift_col++) { // 모든 y 축 평행 이동
					if (possible(shift_row, shift_col)) { // 겹치지 않는다면
						// 액자의 행의 크기: 액자 오른쪽 끝(끝 지점) - 액자 왼쪽 끝(시작 지점) + 1
						// N2는 평행 이동이 된 상태이므로 N1을 똑같이 평행이동해 그 값 중 큰 값이 액자의 오른쪽 끝이다.
						// 왼쪽으로 평행이동 했다면 shift_row가 액자의 시작 점이고, 오른쪽으로 평행이동 했다면 0이 액자의 시작점
						int row = Math.max(N2 - 1, shift_row + N1 - 1) - Math.min(0, shift_row) + 1;
						// 액자의 열의 크기: 액자 아래쪽 끝(끝 지점) - 액자 위쪽 끝(시작 지점) + 1
						// M2는 평행 이동이 된 상태이므로 M1을 똑같이 평행이동해 그 값 중 큰 값이 액자의 아래쪽 끝이다
						// 위쪽으로 평행이동 했다면 shift_row가 액자의 위쪽 끝(시작 점), 아래로 평행이동 했다면 0이 액자의 위쪽 끝(시작점)
						int col = Math.max(M2 - 1, shift_col + M1 - 1) - Math.min(0, shift_col) + 1;
						answer = Math.min(answer, row * col);
					}
				}
			}

		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
