package level1.완주하지못한선수;


/*
	https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();

		for (String player : participant) {
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		}

		for (String player : completion) {
			hm.put(player, hm.get(player) - 1);
		}

		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			if (entry.getValue() == 1) {
				answer = entry.getKey();
			}
		}
		return answer;
	}
}
