package level1.크기가작은부분문자열;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/147355

    숫자로 이루어진 문자열 t, p가 주어짐.
    t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수
	최대 10,000자리 -> 10^9999 -> long
*/

class Solution {
	public int solution(String t, String p) {
		int answer = 0;

		long num = Long.parseLong(p);
		int L = 0;
		int R = p.length();

		while (R <= t.length()) {
			long a = Long.parseLong(t.substring(L, R));

			if (a <= num) {
				answer++;
			}

			L++;
			R++;
		}

		return answer;
	}
}
