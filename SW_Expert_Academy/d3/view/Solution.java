package d3.view;

import java.io.IOException;
import java.util.Scanner;

/*
	- 왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2이상의 공간이 확보될 때 조망권이 확보
	- 가로 길이는 1000이하 (열)

	// 테스트 첫 줄: 건물의 개수 N (4 <= N <= 1,000)
	// 그 다음 줄: N개의 건물의 높이가 주어짐
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}

			int answer = 0;

			// 2번 건물부터 n-3번 건물 까지
			for (int idx = 2; idx < n - 2; idx++) {
				int max;
				// 2번 건물은 오른쪽만 확인
				if (idx == 2) {
					max = Math.max(arr[idx + 1], arr[idx + 2]);

					if (max < arr[idx]) {
						answer += arr[idx] - max;
					}
				} else if (idx == n - 3) {
					max = Math.max(arr[idx - 1], arr[idx - 2]);
					if (max < arr[idx]) {
						answer += arr[idx] - max;
					}
				} else { // 나머지는 왼쪽 2칸, 오른쪽 2칸 확인
					max = Math.max(Math.max(arr[idx - 1], arr[idx - 2]), Math.max(arr[idx + 1], arr[idx + 2]));
					if (max < arr[idx]) {
						answer += arr[idx] - max;
					}
				}
				// n - 3번 건물은 왼쪽만 확인
			}

			System.out.println("#" + i + " " + answer);
		}
	}

}
