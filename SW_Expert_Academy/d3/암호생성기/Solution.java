package d3.암호생성기;

/*
	# 1225. 암호생성기

	- 8개의 숫자를 입력 받는다
	- 첫 번째 숫자를 1 감소한 뒤 제일 뒤로 보낸다
	- 두 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음은 3을 감소하고 맨뒤, 4, 5 차례대로 감소해서 뒤로 보낸다
	- 이 작업을 한 사이클이라 한다. (1 ~ 5 까지 차례대로 빼서 뒤로 보내기)
	- 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료
	- 이 때의 8자리의 숫자 값이 암호가 된다

 */

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int T;
	static Queue<Integer> que;

	static void input() throws IOException {
		T = Integer.parseInt(br.readLine());

		que = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			que.add(Integer.parseInt(st.nextToken()));
		}
	}

	static void pro() {
		int idx = 1;
		while (true) {
			int cur = que.poll() - idx;

			if (cur <= 0) {
				que.offer(0);
				break;
			} else {
				que.offer(cur);
			}

			idx = (idx % 5) + 1;
		}

		sb.append('#').append(T).append(' ');
		for (int n : que) {
			sb.append(n).append(' ');
		}
		sb.append('\n');
	}

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			input();
			pro();
		}
		System.out.print(sb);
	}

}
