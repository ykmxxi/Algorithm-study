package d2.최빈수구하기;

/*
	# 1204 최빈수 구하기

	- 1,000명의 수학 성적을 토대로 통계 자료를 만들려 함
	- 최빈수를 이용해 평균 수준을 짐작, 최빈수는 가장 여러 번 나타나는 값을 의미
	- 최빈수를 출력하는 프로그램 (최빈수가 여러 개 일 때에는 가장 큰 점수를 출력

 */

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int T, tc;
	static int[] counts;
	static Info[] infos;

	static class Info implements Comparable<Info> {
		private int score;
		private int cnt;

		public Info(int score, int cnt) {
			this.score = score;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Info o) {
			// cnt를 기준으로 내림차순
			if (o.cnt == this.cnt) { // cnt가 같으면 점수를 기준으로 내림차순
				return o.score - this.score;
			}
			return o.cnt - this.cnt;
		}
	}

	static void input() throws IOException {
		tc = Integer.parseInt(br.readLine());

		counts = new int[101];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 1000; i++) {
			int score = Integer.parseInt(st.nextToken());
			counts[score]++;
		}
	}

	static void pro() {
		infos = new Info[101];

		for (int i = 0; i < counts.length; i++) {
			infos[i] = new Info(i, counts[i]);
		}

		Arrays.sort(infos);
		sb.append('#').append(tc).append(' ').append(infos[0].score).append('\n');
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			input();
			pro();
		}

		System.out.print(sb);
	}
}
