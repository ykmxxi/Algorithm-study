package level2.n개의최소공배수;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12953
*/

class Solution {

	static int GCD(int a, int b) { // 최대 공약수
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}

	static int LCM(int a, int b) { // 최소 공배수
		return a / GCD(a, b) * b;
	}

	public int solution(int[] arr) {
		int answer = 0;

		if (arr.length == 1) {
			answer = arr[0];
		} else {
			answer = LCM(arr[0], arr[1]);

			for (int i = 2; i < arr.length; i++) {
				answer = LCM(answer, arr[i]);
			}
		}

		return answer;
	}
}
