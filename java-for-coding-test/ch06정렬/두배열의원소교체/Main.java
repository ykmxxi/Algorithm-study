package ch06정렬.두배열의원소교체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static int[] A, B;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N];
		B = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		long answer = 0L;
		// A는 오름차순, B는 내림차순
		Arrays.sort(A);

		Integer[] bArr = Arrays.stream(B)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.toArray(Integer[]::new);

		for (int i = 0; i < K; i++) {
			int temp = 0;

			if (A[i] < bArr[i]) {
				temp = A[i];
				A[i] = bArr[i];
				bArr[i] = temp;
			} else { // A 배열이 더 큰 순간이 오면 더이상 바꿔치기를 하지 않아도 됨
				break;
			}
		}

		for (int num : A) {
			answer += num;
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
