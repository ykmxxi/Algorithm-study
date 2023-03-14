package 완전탐색.토너먼트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, A, B;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}

	static boolean isPair(int a, int b) {
		int sum = a + b;

		return (sum / 2) % 2 == 1 && Math.abs(a - b) == 1;
	}

	static int nextNum(int a) {
		if (a % 2 == 1) {
			return a / 2 + 1;
		} else {
			return a / 2;
		}
	}

	static void pro() {
		int answer = 1;
		// 두 번호를 다음 라운드에 계속 진출시키면 쌍을 이루는 순간이 오는지 판단

		while (!isPair(A, B)) {
			A = nextNum(A);
			B = nextNum(B);
			answer++;
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
