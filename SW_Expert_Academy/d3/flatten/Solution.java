package d3.flatten;

/*
	# 1208 Flatten

	- 한 쪽 벽면에 노란색 상자들이 쌓여있다
	- 평탄화: 높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이려 함
	- 평탄화를 모두 수행하고 나면 가장 높은 곳과 낮은 곳의 차이가 최대 1 이내가 됨
	- 작업 횟수에 제한이 걸려 있을 때 제한된 횟수만큼 옮겨 작업한 후 최고점과 최저점의 차이를 반환

	- 가로 길이는 항상 100
	- 모든 위치에서 상자의 높이는 1이상 100 이하
	- 덤프 횟수는 1 이상 1000이하
 */

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, max, min;
	static int[] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[100];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 100; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, A[i]);
			min = Math.min(min, A[i]);
		}
	}

	static void pro(int tc) {
		int answer = 0;

		while (N > 0) {
			for (int i = 0; i < 100; i++) {
				if (N == 0) {
					break;
				}

				if (max == A[i]) {
					A[i]--;
					max--;
					for (int j = 0; j < 100; j++) {
						if (min == A[j]) {
							A[j]++;
							min++;
							break;
						}
					}

					N--;

					for (int j = 0; j < 100; j++) {
						max = Math.max(max, A[j]);
						min = Math.min(min, A[j]);
					}
				}
			}
		}

		sb.append('#').append(tc).append(' ').append(max - min).append('\n');
	}

	public static void main(String[] args) throws IOException {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			input();
			pro(i + 1);
		}

		System.out.println(sb);
	}
}
