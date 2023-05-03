package level1.개인정보수집유효기간;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/150370

    - 1 ~ n번으로 분류되는 개인정보 n개가 존재
    - 약관 종류는 여러 가지가 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있음
    - 수집된 개인정보는 유효기간 전까지만 보관 가능, 유효기간이 지나면 반드시 파기해야 함
        - A의 유효기간이 12달, 2021년 1월 5일에 수집되었으면, 2022년 1월 4일까지 보관 가능, 2022년 1월 5일부터 파기
    - 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려고 함
    - 모든 달은 28일까지 있다고 가정
        1년: 12 * 28

    - 오늘 날짜를 의미하는 문자열 today: "YYYY.MM.DD" 형태
    - 약관의 유효기간을 담은 1차원 문자열 배열 terms: "A 6" -> A약관의 유효기간은 6달
        - 약관 종류: A ~ Z, 유효기간: 1 ~ 100
        - 약관 종류는 중복되지 않음
    - 수집된 개인정보의 정보를 담은 배열 privacies: "YYYY.MM.DD A" -> A약관을 YYYY년 MM월 DD일에 수집함
        - 날짜는 today 이전의 날짜만 주어짐

    1. terms를 돌며 약관들의 유효기간을 저장 (HashMap)
    2. privacies를 돌며 약관의 종류를 확인하고 유효기간 + 수집 일자를 더해 오늘 이전인지 이후인지 확인
        2.1 이후이면 파기 (해당 약관의 idx + 1을 answer 배열에 저장)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> list = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();

		// 약관종류
		for (String term : terms) {
			map.put(term.split(" ")[0], term.split(" ")[1]);
		}

		int year = Integer.parseInt(today.split("[.]")[0]);
		int month = Integer.parseInt(today.split("[.]")[1]);
		int day = Integer.parseInt(today.split("[.]")[2]);

		// 개인정보 수집일자
		for (int i = 0; i < privacies.length; i++) {
			String date = privacies[i].split(" ")[0];
			int type = Integer.parseInt(map.get(privacies[i].split(" ")[1])) * 28;

			int num = (year - Integer.parseInt(date.split("[.]")[0])) * 28 * 12 // 연
				+ (month - Integer.parseInt(date.split("[.]")[1])) * 28 // 월
				+ (day - Integer.parseInt(date.split("[.]")[2])); // 일

			if (num >= type) { // 오늘 날짜에서 개인 정보 수집일자를 빼 만료일수 보다 크면 파기해야 함
				list.add(i + 1);
			}
		}

		// 1번 정보부터 차례대로 돌기 때문에 정렬을 할 필요는 없음
		return list.stream()
			.mapToInt(i -> i)
			.toArray();
	}

}
