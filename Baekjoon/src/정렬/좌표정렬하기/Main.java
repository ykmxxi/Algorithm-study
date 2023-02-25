package 정렬.좌표정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static Dot[] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new Dot[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A[i] = new Dot();

			A[i].x = Integer.parseInt(st.nextToken());
			A[i].y = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		Arrays.sort(A);

		for (Dot dot : A) {
			sb.append(dot.x).append(' ').append(dot.y).append('\n');
		}
		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static class Dot implements Comparable<Dot> {
		int x;
		int y;

		public Dot() {
		}

		@Override
		public int compareTo(Dot other) {
			if (this.x != other.x) {
				return this.x - other.x;
			}
			return this.y - other.y;
		}
	}
}
