package level2.피보나치수;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12945

    !! (A + B) % C = ((A % C) + (B % C)) % C
*/

class Solution {
	private static final int MOD = 1234567;

	static int fibonacci(int n) {
		int[] answer = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				answer[i] = 0;
				continue;
			}

			if (i == 1) {
				answer[i] = 1;
				continue;
			}

			int sum = answer[i - 1] + answer[i - 2]; // (A % C) + (B % C)
			answer[i] = sum % MOD; // ((A % C) + (B % C)) % C
		}

		return answer[n];

	}

	public int solution(int n) {
		int answer = fibonacci(n);
		return answer;
	}
}
