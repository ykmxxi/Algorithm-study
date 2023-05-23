package lv2.할인행사;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/131127

    # 할인 행사
    - XYZ 마트는 일정 금액을 지불하면 10일 동한 회원 자격을 부여
    - 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 진행, 할인 제품은 하루에 하나만 구매 가능
    - 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 함
    - ex: 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개를 원할 때
        - 마트의 15일 할인하는 제품: 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나인 경우
        - 셋째 날 or 넷째 날 or 다섯째 날부터 각각 열흘은 원하는 제품과 수량이 일치
        - answer = 3
    - 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return, 가능한 날이 없으면 0을 return

    ## 제한 사항
    - 1 <= want.length = number.length <= 10
    - number[i] = want[i]의 수량
    - 1 <= number[i] <= 10
    - number의 원소의 합은 10
    - 10 <= discount.length <= 100,000
    - want와 discount의 원소들은 길이가 1 이상 12 이하인 알파벳 소문자로 이루어진 문자열
*/

class Solution {

	static boolean check(int start, String[] want, int[] number, String[] discount) {
		int[] tmp = number.clone();

		for (int i = start; i < start + 10; i++) {
			for (int idx = 0; idx < want.length; idx++) {
				if (want[idx].equals(discount[i])) {
					tmp[idx]--;
				}
			}
		}

		for (int cnt : tmp) {
			if (cnt > 0) {
				return false;
			}
		}

		return true;
	}

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		for (int start = 0; start <= discount.length - 10; start++) {
			if (check(start, want, number, discount)) {
				answer++;
			}
		}
		return answer;
	}
}
