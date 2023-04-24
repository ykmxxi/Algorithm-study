package 그리디.주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, target;
	static int[] dist, price, visit;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		dist = new int[N - 1];
		price = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
	}

	static boolean find(int idx) {
		for (int i = idx; i < N - 1; i++) {
			if (price[idx] > price[i]) {
				target = i;
				return true;
			}
		}

		return false;
	}

	static void pro() {
		long answer = 0L;
		visit = new int[N];

		for (int i = 0; i < N - 1; i++) {
			if (visit[i] == 1) {
				continue;
			}

			if (find(i)) { // 다음 도시들 중 싼 주유소가 있으면
				for (int j = i; j < target; j++) {
					visit[j] = 1;
					answer += (long)dist[j] * price[i];
				}

			} else { // 다음 도시들 중 싼 주유소가 없으면
				for (int j = i; j < dist.length; j++) {
					answer += (long)dist[j] * price[i];
				}
				break;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
