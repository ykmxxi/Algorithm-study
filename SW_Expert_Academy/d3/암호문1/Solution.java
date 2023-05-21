package d3.암호문1;

/*
	# 1228. 암호문 1

	- 0 ~ 999,999 사이의 수를 나열하여 만든 암호문이 존재
	- 암호 처리기의 기능
		- I(삽입) x, y, s: 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입, s는 덧붙일 숫자
		- I 3 2 123152
	- 위의 규칙에 맞게 잓어된 명령어를 나여해 만든 문자열이 주어졌을 때 암호문을 수정하고, 수정된 결과의 처음 10개를 출력

	## 입력
	총 10개의 테케가 주어짐
	- 첫째 줄: 원본 암호문의 길이
	- 둘째 줄: 원본 암호문
	- 셋째 줄: 명령어의 개수
	- 넷째 줄: 명령어
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static LinkedList<Integer> origin;
	static ArrayList<Integer>[] orders;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		origin = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			origin.add(Integer.parseInt(st.nextToken()));
		}

		M = Integer.parseInt(br.readLine());
		orders = new ArrayList[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			orders[i] = new ArrayList<>();

			String str = st.nextToken();
			int idx = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			orders[i].add(idx); // 리스트의 첫 번째 값은 바꿀 위치
			for (int j = 0; j < cnt; j++) {
				orders[i].add(Integer.parseInt(st.nextToken()));
			}
		}

	}

	static void pro(int tc) {
		for (ArrayList<Integer> order : orders) {
			int start = order.get(0);

			for (int i = 1, idx = start; i < order.size(); i++, idx++) {
				origin.add(idx, order.get(i));
			}
		}

		sb.append('#').append(tc).append(' ');
		for (int i = 0; i < 10; i++) {
			sb.append(origin.get(i)).append(' ');
		}
		sb.append('\n');
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			input();
			pro(tc);
		}

		System.out.print(sb);
	}
}
