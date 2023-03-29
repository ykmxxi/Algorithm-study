package ch06정렬.성적이낮은순서로학생출력하기;

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
	static Student[] A;

	static class Student implements Comparable<Student> {

		public String name;
		public int score;

		@Override
		public int compareTo(Student other) {
			return this.score - other.score;
		}

	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new Student[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			A[i] = new Student();
			A[i].name = st.nextToken();
			A[i].score = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		Arrays.sort(A);

		for (Student s : A) {
			sb.append(s.name).append(' ');
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
