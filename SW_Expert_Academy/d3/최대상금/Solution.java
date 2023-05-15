package d3.최대상금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	1244번 최대 상금
	시간: 20초 이내, 메모리: 256MB 이내

	- 퀴즈 대회 우승시 보너스 상금 획득, 주어진 숫자판들 중 두 개를 선택해서 정해진 횟수만큼 서로의 자리를 위치를 교환 가능
		ex: [3, 2, 8, 8, 8] 2회 교환 가능
		1회: [8, 2, 8, 3, 8] -> 1번과 4번이 교환
		2회: [8, 8, 8, 3, 2] -> 2번과 5번이 교환
		-> 88832원 획득
	- 반드시 횟수만큼 교환이 이루어져야 하고, 동일한 위치의 교환이 중복되어도 됨: 1번 3번 교환 후 다시 1번 3번 교환 가능
	- 정해진 횟수만큼 교환했을 때 받을 수 있는 가장 큰 금액

	# 입력
	- 첫 줄: 테스트 케이스의 수
		최대 10개
	- 둘째 줄부터 각 줄에 숫자판의 정보, 교환 횟수가 주어짐
		123 1 -> [1, 2, 3] 1회 교환 가능
	# 출력
	- #C 가장 큰 금액
		#1 321

 */
public class Solution {

	static int answer;

	static int[] stringToArray(String str) {
		int[] arr = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			arr[i] = Integer.parseInt(str.substring(i, i + 1));
		}
		return arr;
	}

	static void dfs(int start, int depth, int count, int[] arr) {
		StringBuilder sb = new StringBuilder();
		if (depth == count) {
			for (int num : arr) {
				sb.append(num);
			}
			answer = Math.max(Integer.parseInt(sb.toString()), answer);

		} else {
			for (int i = start; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] <= arr[j]) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;

						dfs(i, depth + 1, count, arr);

						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
		}
	}

	static String pro(int[] nums, int count, int tc) {
		answer = Integer.MIN_VALUE;
		dfs(0, 0, count, nums);

		StringBuilder sb = new StringBuilder();
		sb.append('#').append(tc).append(' ').append(answer);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] nums = stringToArray(st.nextToken());
			int count = Integer.parseInt(st.nextToken());

			System.out.println(pro(nums, count, i));
		}

	}

}
