package 완전탐색.리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static boolean[] A; // 고장난 버튼을 저장

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		A = new boolean[12]; // 0 ~ 9, +, -
		if (M != 0) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < M; i++) {
				String s = st.nextToken();
				if (s.equals("+")) {
					A[10] = true;
				} else if (s.equals("-")) {
					A[11] = true;
				} else {
					A[Integer.parseInt(s)] = true;
				}
			}
		}
	}

	static boolean canMove(int num) { // 리모컨을 조작해 갈 수 있는지 판단
		do {
			if (A[num % 10]) {
				return false;
			}
			num = num / 10;
		} while (num > 0);

		return true;
	}

	static int getLength(int num) { // 숫자의 자리수 계산
		int len = 0;

		do {
			len++;
			num /= 10;
		} while (num > 0);

		return len;
	}

	static int changeAndMove() {
		int result = 499900;

		for (int i = 0; i <= 999999; i++) { // 옮겨야 할 500,000 까지 채널이 존재, 채널을 999,999 까지 이동할 경우가 생김
			if (canMove(i)) { // i번 채널을 누를 수 있으면
				int dist = getLength(i) + Math.abs(i - N);

				result = Math.min(result, dist);
			}
		}

		return result;
	}

	static void pro() {
		int answer = 0;

		// 100 에서 + or - 로 이동
		answer = Math.abs(N - 100);

		// 수동으로 채널을 조정한 후 + or - 로 이동
		answer = Math.min(answer, changeAndMove());

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
