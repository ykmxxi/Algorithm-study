package level1.체육복;

/*
    바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다
    4번: 3번 or 5번

    전체 학생 수:n
    체육복을 도난 당한 학생들의 번호: lost
    reserve: 빌려줄 수 있는 하생

    체육수업을 들을 수 있는 학생의 최대값(체육복을 입고있는 학생 수)
*/

import java.util.Arrays;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		// 1번 부터 차례대로 오름차순
		Arrays.sort(lost);
		Arrays.sort(reserve);

		// 먼저 reserve 중 잃어버린 학생 체크
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] == lost[j]) {
					lost[j] = -1;
					reserve[i] = -1;
					answer++;
				}
			}
		}

		for (int i = 0; i < lost.length; i++) {
			if (lost[i] == -1) {
				continue;
			}
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] - 1 == reserve[j]) {
					reserve[j] = -1;
					answer++;
					break;
				}
				if (lost[i] + 1 == reserve[j]) {
					reserve[j] = -1;
					answer++;
					break;
				}
			}
		}

		return answer;
	}
}
