package level1.신규아이디추천;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/72410

    - 새로 가입한 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천
    - 카카오 아이디의 규칙
        1. 아이디의 길이는 3 이상 15 이하
        2. 알파벳 소문자, 숫자, '-', '_', '.' 문자만 사용 가능
        3. 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 연속으로 사용할 수 없다

    - 새로운 아이디 추천 단계, new_id는 신규 유저가 입력한 아이디
        1. new_id의 모든 대문자를 대응되는 소문자로 치환
        2. new_id에서 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거
        3. new_id에서 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        4. new_id에서 마침표가 처음이나 끝에 위치하면 제거
        5. new_id가 빈 문자열이면 "a"를 대입
        6. 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        7. new_id의 길이가 2자 이하라면 마지막 문자를 3이 될 때까지 반복해서 끝에 붙인다.
*/

class Solution {

	static boolean check(String id) {
		// 길이는 3 이상 15 이하
		if (id.length() < 3 || id.length() > 15) {
			return false;
		}

		// 소문자, 숫자, 빼기, 밑줄, 마침표만 사용 가능
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				continue;
			}
			if (ch >= '0' && ch <= '9') {
				continue;
			}
			if (ch == '-' || ch == '_') {
				continue;
			}
			if (ch == '.') {
				if (i == 0 || i == id.length() - 1) {
					return false;
				}

				if (id.charAt(i + 1) == '.') {
					return false;
				}
				continue;
			}

			return false;
		}

		return true;
	}

	static String recommend(String new_id) {
		// 1 단계
		String id = new_id.toLowerCase();

		// 2단계
		id = id.replaceAll("[^-_.\\w]", "");

		// 3 단계
		id = id.replaceAll("[.]{2,}", ".");

		// 4 단계
		id = id.replaceAll("^[.]|[.]$", "");

		// 5 단계
		if (id.equals("")) {
			id = "a";
		}

		// 6 단계
		if (id.length() > 15) {
			id = id.substring(0, 15);
			id = id.replaceAll("[.]$", ""); // 자른 문자열의 마지막이 마침표이면 없애기
		}

		// 7 단계
		if (id.length() < 3) {
			while (id.length() < 3) {
				id = id.concat(String.valueOf(id.charAt(id.length() - 1)));
			}
		}

		return id;
	}

	public String solution(String new_id) {
		String answer = "";

		// 규칙에 맞는지 확인한다
		if (!check(new_id)) { // 규칙에 맞지 않으면
			answer = recommend(new_id);
		} else { // 규칙에 맞으면
			answer = new_id;
		}

		return answer;
	}
}
