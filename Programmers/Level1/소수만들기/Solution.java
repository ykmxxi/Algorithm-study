package level1.소수만들기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12977

    주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하는 문제
    nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return
    nums.length개 중 3개를 고르기(조합) + 3개를 더했을 때 소수인지 판단

*/

class Solution {
	static int answer;
	static int[] prime = new int[3001]; // 0: 소수, 1: 소수X

	static void getPrimes() {
		prime[0] = prime[1] = 1;

		for (int i = 2; i <= Math.sqrt(3000); i++) {
			if (prime[i] == 0) {
				for (int j = i * i; j <= 3000; j += i) {
					prime[j] = 1;
				}
			}
		}
	}

	static void rec_func(int depth, int start, int sum, int[] nums) {
		if (depth == 3) {
			if (prime[sum] == 0) {
				answer++;
			}
		} else {
			for (int cand = start; cand < nums.length; cand++) {
				rec_func(depth + 1, cand + 1, sum + nums[cand], nums);
			}
		}
	}

	public int solution(int[] nums) {

		getPrimes();
		rec_func(0, 0, 0, nums);

		return answer;
	}
}
