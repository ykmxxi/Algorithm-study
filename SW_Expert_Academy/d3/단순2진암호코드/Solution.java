package d3.단순2진암호코드;

/*
	# 1240 단순 2진 암호코드

	- 암호코드는 8개의 숫자로 이루어짐
	- 올바른 암호코드는 (홀수 자리의 합 x 3) + (짝수 자리의 합) 이 10의 배수가 되어야 함
	- 이 암호코드를 빠르고 정확하게 인식할 수 있는 스캐너
		- 스캐너는 암호코드 1개가 포함된 직사각형 배열을 읽는다
		- 직사각형 배열은 1, 0으로만 이루어져 있고 암호코드 이외의 부분은 전부 0
		- 암호코드에서 숫자 하나는 7개의 비트로 암호화되어 주어짐. 따라서 암호코드의 가로 길이는 56
	- 비정상적인 암호코드는 주어지지 않음 -> 다 읽고 저장할 필요가 없음
	- 35 * 8 = 280개, 1이 마지막으로 나온 idx - 시작 idx + 1 = 280
 */

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static String[] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}
	}

	static int decrypt(String str) {
		switch (str) {
			case "0001101":
				return 0;
			case "0011001":
				return 1;
			case "0010011":
				return 2;
			case "0111101":
				return 3;
			case "0100011":
				return 4;
			case "0110001":
				return 5;
			case "0101111":
				return 6;
			case "0111011":
				return 7;
			case "0110111":
				return 8;
			default:
				return 9;
		}
	}

	static void pro(int tc) {
		// 1. 1이 마지막으로 나온 idx 번호 알아내기
		int lastX = 0, lastY = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < A[i].length(); j++) {
				if (A[i].charAt(j) == '1') {
					lastX = i;
					lastY = j;
				}
			}
		}

		int startX = lastX - 4;
		int startY = lastY - 55;

		// 2. 암호코드 저장, 첫 줄만 보면 됨
		String[] codes = new String[8];
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			StringBuilder tmp = new StringBuilder();

			while (cnt < 7) {
				tmp.append(A[startX].charAt(startY));
				startY++;
				cnt++;
			}

			codes[i] = tmp.toString();
			cnt = 0;

		}

		// 3. 해독
		int[] decrypted = new int[8];
		for (int i = 0; i < 8; i++) {
			decrypted[i] = decrypt(codes[i]);
		}

		int sum = 0;
		int answer = 0;
		for (int i = 0; i < 8; i++) {
			answer += decrypted[i];

			if (i % 2 == 0) {
				sum += decrypted[i] * 3;
			} else {
				sum += decrypted[i];
			}
		}

		sb.append('#').append(tc + 1).append(' ');
		if (sum % 10 == 0) {
			sb.append(answer).append('\n');
		} else {
			sb.append(0).append('\n');
		}
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			input();
			pro(i);
		}

		System.out.println(sb);
	}

}
