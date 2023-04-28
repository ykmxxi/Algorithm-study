package 문자열.그룹단어체커;

import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static String[] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}
	}

	static boolean check(String str) {
		int[] used = new int[26];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (used[ch - 'a'] == 0) { // 처음 나온 알파벳이면
				used[ch - 'a'] = 1;
				continue;
			}

			if (str.charAt(i) == str.charAt(i - 1)) { // 이전 알파벳과 같으면
				continue;
			}

			return false;
		}

		return true;
	}

	static void pro() {
		int answer = 0;

		for (String str : A) {
			if (check(str)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
