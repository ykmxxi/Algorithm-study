package level1.소수찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12921
 * 2 이상 1,000,000 이하의 자연수 n이 주어졌을 때 1 부터 n 사이에 있는 소수의 개수를 찾는 문제
 * 에라토스테네스의 체
 */

import java.util.*;

class Solution {
	static int[] prime = new int[1000001]; // 0이면 소수, 1이면 소수X

	static void getPrime(int n) {
		prime[0] = prime[1] = 1; // 0과 1은 소수가 아님

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (prime[i] == 0) { // 소수이면 자신을 제외한 나머지 배수들은 모두 소수가 아님
				for (int j = i * i; j <= n; j += i) { // 2 * i 부터가 아님 i * i 부터 시작,
					// 이전 소수에서 이미 배수로 처리되었으므로 i * i 부터 시작해야 효율적
					// i = 5 이면, 5 * 2, 5 * 3, 5 * 4 다 처리 되어있으므로 5 * 5 부터 시작
					prime[j] = 1;
				}
			}
		}
	}

	public int solution(int n) {
		ArrayList<Integer> primeList = new ArrayList<>();
		getPrime(n);

		for (int i = 2; i <= n; i++) {
			if (prime[i] == 0) {
				primeList.add(i);
			}
		}

		return primeList.size();
	}
}
