package level2.숫자의표현;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12924

    2로 나눈 값 까지만 식의 시작점이 될 수 있음 15: 7 + 8 16: 8 + 8, 17: 8 + 9
*/

class Solution {
	public int solution(int n) {
		int answer = 1; // 자기 자신

		for (int i = 1; i <= n / 2; i++) { // 2로 나눈 값 까지만 시작점으로
			int sum = 0;

			for (int j = i; j <= n; j++) {
				if (sum > n) { // n 보다 커지면 답이 없음
					break;
				}
				if (sum == n) { // n 과 같으면 정답
					answer++;
					break;
				}
				sum += j;
			}

		}
		return answer;
	}
}
