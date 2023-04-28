package 문자열.크로아티아알파벳;

import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String input;
	static int[] visit;
	static String[] ca = {"c=", "c-", "lj", "nj", "s=", "z="};

	static void input() throws IOException {
		input = br.readLine();
		visit = new int[input.length()];
	}
//5 0 1 2 3 4 (34) 5 - 2
	static boolean check(char ch, int idx) {
		if (ch == 'd') {
			String str1 = input.substring(idx, idx + 2);

			if (str1.equals("d-")) {
				visit[idx] = 1;
				visit[idx + 1] = 1;
				return true;
			}

			if (idx <= input.length() - 3) {
				String str2 = input.substring(idx, idx + 3);

				if (str2.equals("dz=")) {
					visit[idx] = 1;
					visit[idx + 1] = 1;
					visit[idx + 2] = 1;
					return true;
				}
			}

		} else {
			String str = input.substring(idx, idx + 2);
			for (String s : ca) {
				if (str.equals(s)) {
					visit[idx] = 1;
					visit[idx + 1] = 1;
					return true;
				}
			}
		}

		return false;
	}

	static void pro() {
		int answer = 0;

		// 크로아티아 알파벳은 c, d, l, n, s, z 중 하나로 시작
		for (int i = 0; i < input.length(); i++) {
			if (visit[i] == 1) {
				continue;
			}

			char ch = input.charAt(i);
			if (i <= input.length() - 2) {
				if (check(ch, i)) { // 크로아티아 알파벳이면
					answer++;
					continue;
				}
			}

			answer++;
			visit[i] = 1;
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
