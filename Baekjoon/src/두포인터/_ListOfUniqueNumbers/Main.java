package 두포인터._ListOfUniqueNumbers;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] A, count;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		count = new int[100000 + 1]; // 1 부터 100,000 까지 숫자의 존재 여부를 저장하는 배열

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		long answer = 0L;

		for (int L = 1, R = 0; L <= N; L++) { // L 마다 R을 최대한 옮겨 계산
			// R 을 옮길 수 있는 만큼 옮긴다
			while (R + 1 <= N && count[A[R + 1]] == 0) { // R을 옮길 수 있고, 구간 안에 존재하지 않을 때
				R++;
				count[A[R]]++;
			}

			// 정답 갱신
			answer += R - L + 1;

			// L 을 옮기면서 A[L]의 개수를 감소
			count[A[L]]--;
		}

		sb.append(answer);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
