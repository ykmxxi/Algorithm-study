package level2.연속부분수열합의개수;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/131701

    - 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지 인지
    - 원형 수열은 처음과 끝이 연결되기 때문에 연속하는 부분 수열이 일반적인 수열보다 많아진다

    1. 길이가 1 부터 elements.length 만큼인 부분 수열을 차례대로 살핀다
    2. 길이가 n일 때 생기는 값들을 HashSet 에 넣는다
        - 1000개 모두 1000일 때 합은 10^6 (int) -> HashSet<Integer>
    3. 순회가 끝나면 set size를 반환한다
*/

import java.util.HashSet;

class Solution {
	static HashSet<Integer> set;

	static void getValue(int len, int[] arr) {
		int mod = arr.length;

		for (int start = 0; start < arr.length; start++) { // start: 부분 수열의 시작 위치
			int sum = 0; // 부분수열의 합
			int cnt = 0; // 부분수열의 개수
			int idx = start;

			while (cnt < len) {
				sum += arr[idx % mod];
				cnt++;
				idx++;
			}

			set.add(sum);

			if (len == mod) { // 부분수열의 길이가 주어진 배열의 길이와 같으면 같은 1개이므로 종료
				break;
			}
		}
	}

	public int solution(int[] elements) {
		set = new HashSet<>();

		for (int len = 1; len <= elements.length; len++) {
			getValue(len, elements);
		}

		return set.size();
	}
}
