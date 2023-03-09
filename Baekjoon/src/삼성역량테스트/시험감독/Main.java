package 삼성역량테스트.시험감독;

/*
	https://www.acmicpc.net/problem/13458
	총 N개의 시험장 존재, 각각의 시험장마다 응시자들이 존재, i번 시험장에 있는 응시자의 수는 Ai명
	감독관: 총감독관, 부감독관
		총감독관: B명 감시, 시험장에 1명
		부감독관: C명 감시, 시험장에 여러명
	각 시험장 마다 응시생들을 모두 감시해야 함. 이떄 필요한 감독관 수의 최소값을 구하는 문제
	정답의 최대치: 10^6 개의 시험장이 존재하고, 모두 10^6명일 때, B C 가 1이라면, 10^12 만큼 필요
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, B, C;
	static int[] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	}

	static void pro() {
		// 총감독관은 무조건 1명 있어야 한다.
		long answer = 0L;

		for (int i = 1; i <= N; i++) {
			if (A[i] <= B) {
				answer++;
			} else {
				answer++;
				int a = A[i] - B;
				if (a % C == 0) {
					answer += a / C;
				} else {
					answer += a / C + 1;
				}
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
