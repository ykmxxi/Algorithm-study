package 정렬.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int[] A, B;
	static HashMap<Integer, Integer> ranking;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		B = Arrays.stream(A)
			.distinct()
			.sorted()
			.toArray();

		int rank = 0;
		ranking = new HashMap<>();
		for (int num : B) {
			ranking.put(num, rank);
			rank++;
		}

		for (int key : A) {
			sb.append(ranking.get(key)).append(' ');
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
