package d3.원재의메모리복구하기;

/*
	# 1289. 원재의 메모리 복구하기

	- 메모리가 초기화 되어 원래 메모리로 돌리려함
	- 메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌움
		-ex: 3번째 bit를 1로 설정하면 -> 0111
	- 원래 상태가 주어질 때 초기화 상태 에서 원래 상태로 돌아가는데 최소 몇 번 고쳐야 하는지 계산

	## 입력
	- 첫째 줄: 총 테케 수 T
	- 각 테케는 한 줄로 원래 메모리 값이 주어짐
		- 메모리 길이는 1이상 50이하
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static String origin;

	static void input() throws IOException {
		origin = br.readLine();
	}

	static void pro(int tc) {
		int answer = 0;
		int len = origin.length();

		char cur = '0'; // 초기화된 메모리의 시작은 0
		for (int i = 0; i < len; i++) {
			if (origin.charAt(i) == cur) {
				continue;
			}
			cur = origin.charAt(i);
			answer++;
		}

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
