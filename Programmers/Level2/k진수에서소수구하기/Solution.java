package level2.k진수에서소수구하기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/92335

    1. n을 k진수로 변경 -> Integer.toString(n, k);
    2. 0을 delim으로 쪼개기 split("0");
    3. 쪼갠 수가 1 or 빈 문자열이면 넘어가고, 아니면 소수인지 확인
*/

class Solution {

	static boolean isPrime(String str) {
		long num = Long.parseLong(str);

		for (long i = 2L; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public int solution(int n, int k) {
		int answer = 0;

		String str = Integer.toString(n, k); // n을 k진수로 변환
		String[] arr = str.split("0");

		for (String s : arr) {
			if (s.equals("1") || s.equals("")) {
				continue;
			}
			if (isPrime(s)) {
				answer++;
			}
		}

		return answer;
	}
}
