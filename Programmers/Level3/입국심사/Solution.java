package level3.입국심사;

/*
    n명이 입국심사를 위해 줄을 서서 기다림
    - 한 심사대에서는 동시에 한 명만 심사를 할 수 있다
    - 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있다

    - 매개변수 탐색 접근
    - k분으로 n명을 모두 심사할 수 있나? Yes or No
        Yes -> 오른쪽 구간끝 갱신, R = mid - 1
        No -> 왼쪽 구간끝 갱신, L = mid + 1
*/

import java.util.Arrays;

class Solution {

	static long count(int[] times, long x) {
		long sum = 0;

		for (int time : times) {
			sum += x / time;
		}

		return sum;
	}

	public long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);

		long L = 0;
		long R = (long)n * times[times.length - 1];
		while (L <= R) {
			long mid = (L + R) / 2;

			if (count(times, mid) < n) {
				L = mid + 1;
			} else {
				R = mid - 1;
				answer = mid;
			}

		}
		return answer;
	}
}
