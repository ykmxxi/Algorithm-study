package 완전탐색.토너먼트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, A, B;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}

	static void pro() {
		int answer = 1;
		// 두 번호를 다음 라운드에 계속 진출시키면 쌍을 이루는 순간이 오는지 판단
		// 큰 수가 b가 되게 swap (라운드를 구하는 것이기에 두 사람의 번호가 바뀌어도 상관 없음)
		if (A > B) {
			int temp = A;
			A = B;
			B = temp;
		}

		while (true) {
			if (A % 2 == 1 && B - A == 1) {
				break;
			}

			A = (A + 1) / 2;
			B = (B + 1) / 2;
			answer++;
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
