package level2.숫자카드나누기;

/*
	https://school.programmers.co.kr/learn/courses/30/lessons/135807
	다음 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a의 값을 구하는 문제
	두 사람은 카드를 절반씩 나눠서 가진다.
	1. 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수
	2. 영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수
 */

class Solution {

	static int GCD(int a, int b) { // 최대 공약수 찾기
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}

	static boolean check(int[] arr, int gcd) {
		for (int num : arr) {
			if (num % gcd == 0) { // 나눠지면 조건을 만족하지 않음
				return false;
			}
		}

		return true;
	}

	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		int gcdA = arrayA[0];
		int gcdB = arrayB[0];

		for (int i = 0; i < arrayA.length; i++) {
			gcdA = GCD(gcdA, arrayA[i]);
			gcdB = GCD(gcdB, arrayB[i]);
		}


		// 조건 1 확인
		if (check(arrayB, gcdA)) {
			answer = gcdA;
		}

		// 조건 2 확인
		if (check(arrayA, gcdB)) {
			answer = Math.max(answer, gcdB);
		}

		return answer;

	}
}
