package 완전탐색.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String A, B;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		A = st.nextToken();
		B = st.nextToken();
	}

	static int check() {
		int answer = Integer.MAX_VALUE;
		int diff = B.length() - A.length();
		for (int i = 0; i <= B.length() - A.length(); i++) {
			int cnt = 0;

			for (int j = 0; j < A.length(); j++) {
				if (B.charAt(j + i) != A.charAt(j)) {
					cnt++;
				}
			}
			answer = Math.min(cnt, answer);

		}
		return answer;
	}

	static void pro() {
		int answer = 0;

		if (!B.contains(A)) { // A가 B에 포함되어 있으면, 앞뒤에 알파벳을 추가해 똑같은 문자열을 만들 수 있음
			answer = check();
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
