package d3.회문1;

/*
	# 1215. 회문1

	- "기러기", "토마토" 처럼 똑바로 읽어도 거꾸로 읽어도 똑같은 문장이나 낱말을 회문이라 한다
	- 8 x 8 평면의 글자판에 제시된 길이를 가진 회문의 개수를 구하는 문제
	- 각 칸의 들어가는 숫자는 A, B, C
	- ABA 도 회문, ABBA도 회문, A 도 회문
	- 가로 또는 세로로 이어진 회문만 센다

	## 입력
	- 총 10개의 테스트 케이스가 주어짐
	- 각 테스트 케이스의 첫째 줄: 회문의 길이
	- 다음 줄: 8 x 8 크기의 글자판이 주어짐

	## 출력
	- #tc 정답
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int len;
	static String[] A;

	static void input() throws IOException {
		len = Integer.parseInt(br.readLine());

		A = new String[8];

		for (int i = 0; i < 8; i++) {
			A[i] = br.readLine();
		}
	}

	static void pro(int tc) {
		int answer = 0;

		// 가로 회문 체크
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j <= 8 - len; j++) {
				StringBuilder front = new StringBuilder();
				StringBuilder behind = new StringBuilder();
				Stack<Character> stack = new Stack<>();

				for (int k = 0; k < len; k++) {
					front.append(A[i].charAt(j + k));
					stack.push(A[i].charAt(j + k));
				}

				while (!stack.isEmpty()) {
					behind.append(stack.pop());
				}

				if (front.toString().equals(behind.toString())) {
					answer++;
				}
			}
		}

		// 세로 회문 체크
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j <= 8 - len; j++) {
				StringBuilder front = new StringBuilder();
				StringBuilder behind = new StringBuilder();
				Stack<Character> stack = new Stack<>();

				for (int k = 0; k < len; k++) {
					front.append(A[j + k].charAt(i));
					stack.push(A[j + k].charAt(i));
				}

				while (!stack.isEmpty()) {
					behind.append(stack.pop());
				}

				if (front.toString().equals(behind.toString())) {
					answer++;
				}
			}
		}

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 10; i++) {
			input();
			pro(i);
		}

		System.out.print(sb);
	}
}
