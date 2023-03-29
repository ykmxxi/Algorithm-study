package ch06정렬.위에서아래로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	// static Integer[] A;
	static int[] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		// A = new Integer[N];
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
	}

	static void pro() {
		// Arrays.sort(A, Collections.reverseOrder());
		Integer[] arr = Arrays.stream(A)
			.boxed()
			.toArray(Integer[]::new);

		Arrays.sort(arr, Collections.reverseOrder());

		for (int num : arr) {
			sb.append(num).append(' ');
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
