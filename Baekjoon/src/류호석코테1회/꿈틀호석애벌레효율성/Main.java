package 류호석코테1회.꿈틀호석애벌레효율성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static long[] A, Dy;

	// [i]: 구간의 끝점(R), interval.left: 구간의 시작점(L), interval.satisfy: [L, R]의 만족감
	static ArrayList<Interval>[] intervals;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new long[N + 1];
		Dy = new long[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		intervals = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			intervals[i] = new ArrayList<>();
		}

	}

	static void pro() {
		long sum = 0; // 만족도의 총합

		for (int L = 1, R = 0; L <= N; L++) { // L = 1 부터 먹기 시작
			while (sum < K && R + 1 <= N) { // [L R]의 총합이 K보다 작으면 R을 늘린다, 구간을 늘릴 때 늘린 결과가 N보다 크면 안된다
				R++;
				sum += A[R];
				// sum += A[++R];
			}

			if (sum >= K) { // 구간을 늘려서 K보다 커지면, 해당 구간을 저장한다
				Interval i = new Interval();
				i.left = L; // 구간의 시작점 저장
				i.energy = sum - K; // 해당 구간의 탈피 에너지
				intervals[R].add(i); // 구간의 정보를 저장
			}

			sum -= A[L]; // L을 오른쪽으로 한 칸 옮겨주기 위해 총합 에서 A[L]을 빼줌
		}

		for (int R = 1; R <= N; R++) {
			Dy[R] = Dy[R - 1]; // 안 먹은 경우

			for (Interval i : intervals[R]) { // 구간의 끝이 R인 모든 구간에 대해 탐색
				// 점화식: max(Dy[R - 1], max(Dy[L - 1] + Eat(L, R)))
				Dy[R] = Math.max(Dy[R], Dy[i.left - 1] + i.energy);
			}
		}

		System.out.println(Dy[N]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static class Interval { // 먹은 구간
		int left; // 구간의 시작점
		long energy; // 구간의 탈피 에너지
	}
}
