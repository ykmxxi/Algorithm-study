package level2.귤고르기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/138476

    k개를 골라 판매 -> 완전탐색 접근(조합) -> 시간초과
    최대 100,000개 중 k개 고르기(시간초과)

    개수가 많은 순서대로 정렬 후(개수별 내림차순) 순회하며 상자에 담아 k개 이상 시 반복문 종료
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int solution(int k, int[] tangerine) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>(); // Key: 크기, Value: 개수

		for (int type : tangerine) {
			map.put(type, map.getOrDefault(type, 0) + 1);
		}

		List<Integer> keys = new ArrayList<>(map.keySet());
		keys.sort((o1, o2) -> map.get(o2) - map.get(o1)); // 개수별 내림차순 정렬

		for (int key : keys) {
			if (k <= 0) {
				break;
			}
			k -= map.get(key);
			answer++;
		}

		return answer;
	}
}
