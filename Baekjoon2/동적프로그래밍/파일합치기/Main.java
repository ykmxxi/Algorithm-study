package 동적프로그래밍.파일합치기;

/* https://www.acmicpc.net/problem/11066
	소설을 여러 장으로 나누어 쓸때, 각 장은 각각 다른 파일에 저장
	모든 장을 쓰고 파일을 합쳐서 최종적으로 완성봉의 한개 파일 만들기
	두 개의 파일을 합쳐 하나의 임시파일을 만들고 임시 파일이나 원래의 파일을 계속 두 개씩 합쳐서 연속이 되도록 합쳐나가 한 개로
	두 개의 파일을 합칠 때 필요한 비용 = 두 파일 크기의 합, 최종적인 한 개 파일을 완성하는데 필요한 비용의 총 합을 계산하는 문제
 */

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int T, K;
	static int[] A;
	static int[][] Dy; // Dy[i][j] = i번 파일부터 j번 파일까지 최소 합, Dy[1][K] 가 진짜 문제의 정답
	static int[][] sum; // sum[i][j] = i번 파일부터 j - 1번 파일까지 합 + j번 파일의 크기 = i번 파일부터 j번 파일까지 총 합

	static void input() throws IOException {
		K = Integer.parseInt(br.readLine());

		A = new int[K + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= K; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void preprocess() { // 주어진 구간 파일의 합
		sum = new int[K + 1][K + 1];
		for (int i = 1; i <= K; i++) {
			for (int j = i; j <= K; j++) {
				sum[i][j] = sum[i][j - 1] + A[j];
			}
		}
	}

	static void pro() {
		Dy = new int[K + 1][K + 1];
		// 진짜 문제: 1번 부터 K번 까지 파일을 합쳤을 때 최소 비용
		// 가짜 문제: Dy[i][j]: i번 부터 j번 까지 파일을 합쳤을 때 최소 비용, Dy[1][K] 가 진짜 문제의 정답

		for (int len = 2; len <= K; len++) { // 파일 구간의 길이는 2 부터 K 까지, 구간 길이가 1일 때는 0이라 안봐도 됨
			for (int i = 1; i <= K - len + 1; i++) { // i 는 1 부터 (K - 현재 구간의 길이 + 1)번 까지 가능
				int j = i + len - 1; // 시작점이 i이고 길이가 len인 구간의 끝점은 i + len - 1

				Dy[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k + 1][j] + sum[i][j]);
				}

			}
		}


		sb.append(Dy[1][K]).append('\n');
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			input();
			preprocess();
			pro();
		}
		System.out.print(sb);
	}

}
