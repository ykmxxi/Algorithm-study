package d2.조교의성적매기기;

/*
	# 1983. 조교의 성적 매기기

	- 총 10개의 평점이 존재
		- A+, A0, A-, B+, B0, B-, C+, C0, C-, D0
	- 중간, 기말고사 점수 결과 및 과제 점수가 반영
	- 총점 = 중간고사(35%) + 기말고사(45%) + 과제(20%)
	- N 명의 학생이 있을 경우 N / 10 명의 학생들에게 동일한 평점을 부여할 수 있음
	- K 번째 학생의 번호가 주어졌을 때 K 번째 학생의 학점을 출력하는 문제
	- N은 항상 10의 배수, 10 이상 100 이하
	- K는 1 이상 N 이하
	- K 번째 학생의 총점과 다른 학생의 총점이 동일한 경우는 입력으로 주어지지 않음

	## 입력
	- 첫째 줄: 총 테케 개수 T
	- 각 테케 첫째 줄: N K
	- 각 테케 두 번째 줄부터 각각의 학생이 받은 시험 및 과제 점수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, K;
	static String[] arr = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	static Credit[] credits;

	static class Credit implements Comparable<Credit> {
		int number;
		double totalScore;

		public Credit(int number, double totalScore) {
			this.number = number;
			this.totalScore = totalScore;
		}

		@Override
		 public int compareTo(Credit o) {
			return Double.compare(o.totalScore, this.totalScore);
		 }

	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		credits = new Credit[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int midScore = Integer.parseInt(st.nextToken());
			int finalScore = Integer.parseInt(st.nextToken());
			int assignment = Integer.parseInt(st.nextToken());
			double totalScore = midScore * 0.35 + finalScore * 0.45 + assignment * 0.2;

			credits[i] = new Credit(i + 1, totalScore);
		}
	}

	static String getCredit() {
		int limit = N / 10;
		int cnt = 0;
		int idx = 0;

		for (int i = 0; i < N; i++) {
			if (cnt == limit) {
				cnt = 0;
				idx++;
			}

			if (credits[i].number == K) {
				break;
			}

			cnt++;
		}

		return arr[idx];
	}

	static void pro(int tc) {
		Arrays.sort(credits);

		String answer = getCredit();

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}

		System.out.print(sb);
	}
}
