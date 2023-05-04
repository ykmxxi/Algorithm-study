package level2.다음큰숫자;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12911

    자연수 n이 주어질 때, n의 다음 큰 숫자의 정의
    - n의 다음 큰 숫자는 n보다 큰 자연수
    - n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같다
    - n의 다음 큰 숫자는 위 조건을 모두 만족하는 수 중 가장 작은 수

    78(1001110) -> 83(1010011)
    Integer 클래스의 toBinaryString() 이용
*/

class Solution {

	static int count(String str) {
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				cnt++;
			}
		}

		return cnt;
	}

	public int solution(int n) {
		int answer = 0;

		String binaryN = Integer.toBinaryString(n);
		int target = count(binaryN);

		int cnt = 0;
		while (true) {
			String binary = Integer.toBinaryString(++n);
			cnt = count(binary);

			if (cnt == target) {
				answer = n;
				break;
			}
		}

		return answer;
	}
}
