package level3.n으로표현;

/* https://school.programmers.co.kr/learn/courses/30/lessons/42895

    N을 i개 사용했을 때 나타낼 수 있는 모든 숫자를 set에 넣기
    set[i] = N을 i개 사용했을 때 표현할 수 있는 수들의 집합
    set[1] 부터 set[8] 까지 순회하며 number를 포함하고 있는 제일 빠른 인덱스를 리턴
    만약 존재하지 않으면 -1 리턴
*/

import java.util.HashSet;

class Solution {

	static HashSet<Integer>[] set;

	static void preprocess(int N) {
		set = new HashSet[9]; // 8자리 까지만
		int num = 0;

		for (int i = 1; i < 9; i++) { // i개를 사용했을 때, N, NN, NNN, NNNN ..., NNNNNNNN 미리 넣어주기
			num = (num * 10) + N;
			set[i] = new HashSet<>();
			set[i].add(num);
		}

		// 만약 i = 4 이면, 1 + 3, 2 + 2, 3 + 1 -> 총 3개의 경우 존재
		for (int i = 2; i < 9; i++) { // 개수
			for (int j = 1; j < i; j++) { // prev에 올 수 있는 N의 개수 (1, .., i - 1 까지)
				for (int prev : set[j]) {
					for (int post : set[i - j]) {
						set[i].add(prev + post);
						set[i].add(prev - post);
						set[i].add(prev * post);

						if (post != 0) { // 분모에는 0이 오면 안됨
							set[i].add(prev / post);
						}

					}
				}
			}
		}
	}

	public int solution(int N, int number) {
		preprocess(N);

		for (int i = 1; i < 9; i++) {
			if (set[i].contains(number)) {
				return i;
			}
		}

		return -1;
	}
}
