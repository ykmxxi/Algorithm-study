package level2.구명보트;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42885

    구명보트는 한 번에 최대 2명씩 탈 수 있음

    모든 사람을 구출하기 위해 필요한 구명보트의 개수의 최소값을 return
*/

import java.util.Arrays;

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people); // 오름차순으로 정렬

		int L = 0;
		int R = people.length - 1;

		while (L <= R) {
			if (people[L] + people[R] <= limit) { // 제일 가벼운 사람과 제일 무거운 사람을 태울 수 있으면
				L++; // 제일 가벼운 사람 태우기
				R--; // 제일 무거운 사람 태우기
				answer++;
			} else { // 1명만 태울 수 있으면
				R--; // 제일 무거운 사람 태우기
				answer++;
			}
		}

		return answer;
	}

}
