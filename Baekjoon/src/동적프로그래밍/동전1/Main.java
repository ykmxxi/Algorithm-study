package 동적프로그래밍.동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static int[] A, Dy;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
	}

	static void pro() {
		Arrays.sort(A);

		Dy = new int[K + 1];
		Dy[0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= A[i]) {
					Dy[j] += Dy[j - A[i]];
				}
			}
		}

		System.out.println(Dy[K]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
