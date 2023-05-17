package d2.수도요금경쟁;

/*
	# 1284. 수도 요금 경쟁

	- 집의 위치가 두 수도 회사 A, B 중간에 위치하기에 원하는 수도 회사 선택 가능
	- 두 회사 중 더 적게 수도 요금을 부담해도 되는 회사를 고르려고함
	- A: 1리터당 P원의 돈을 내야함
	- B: 기본 요금 Q, 월간 사용량이 R리터 이하인 경우 기본 요금만 청구, 초과시 초과량 1리터당 S원
	- 한 달 수도의 양이 W리터라고 할 때 더 저렴한 회사를 골라 요금을 출력하는 문제

	## 입력
	- 첫째 줄: 테스트 케이스 수 T
	- 각 테스트 케이스 첫째 줄: P Q R S W
		- 1 <= P, Q, R, S, W <= 10,000
		- 정답의 최대치: 10,000 리터를 기본 요금 10,000 이용 -> 10^8 (1억) -> int

	## 출력
	- #x 정답
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int P, Q, R, S, W;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");

		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
	}

	static void pro(int tc) {
		int answer = 0;

		// 1. A사 요금 계산: 리터당 P원
		int feeA = W * P;

		// 2. B사 요금 계산: 기본 요금 Q, 월간 사용량이 R리터 이하인 경우 기본 요금만 청구, 초과시 초과량 1리터당 S원
		int feeB = 0;
		if (W <= R) {
			feeB = Q;
		} else {
			feeB = Q + (W - R) * S;
		}

		// 3. 최소 요금
		answer = Math.min(feeA, feeB);

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			input();
			pro(i);
		}

		System.out.print(sb);
	}
}
