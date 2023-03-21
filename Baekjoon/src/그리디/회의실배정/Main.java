package 그리디.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static Meeting[] meetings;

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Meeting o) { // 끝나는 시간을 기준으로 오름차순 정렬
			if (this.end == o.end) { // 끝나는 시간이 같으면 시작 시간기준 오름차순 정렬
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
	}

	static void pro() {
		Arrays.sort(meetings);
		int answer = 1;
		int cur = meetings[0].end;

		for (int i = 1; i < meetings.length; i++) {
			if (meetings[i].start >= cur) {
				cur = meetings[i].end;
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
