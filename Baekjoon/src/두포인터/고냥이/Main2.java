package 두포인터.고냥이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, kind;
	static String str;
	static int[] count;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		count = new int[26];
	}

	static void add(char x) { // 알파벳을 count 배열에 추가
		count[x - 'a']++;
		if (count[x - 'a'] == 1) { // 새롭게 나타나면 kind++
			kind++;
		}
	}

	static void remove(char x) { // 알파벳을 count 배열에서 삭제
		count[x - 'a']--;
		if (count[x - 'a'] == 0) { // 모두 없어지면 kind--
			kind--;
		}
	}

	static void pro() {
		int length = str.length();
		int answer = 0;

		for (int R = 0, L = 0; R < length; R++) {
			// R 번째 문자를 오른쪽에 추가
			add(str.charAt(R));

			// 불가능하면, 가능할 때까지 L을 이동
			while (kind > N) {
				remove(str.charAt(L));
				L++;
			}

			// 정답 갱신
			answer = Math.max(answer, R - L + 1);
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
