package level1.푸드파이트대회;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/134240

    푸드 파이터 대회: 선수들은 1:1 대결, 매 대결마다 음식의 종류와 양이 바뀜
    준비된 음식들을 일렬로 배치한 뒤, 한 선수는 제일 왼쪽부터 오른쪽, 다른 선수는 제일 오른쪽부터 왼쪽
    중앙에는 물을 배치, 물을 먼저 먹는 선수가 승리
    두 선수가 먹는 음식의 종류와 양이 같아야 하고, 먹는 순서도 같아야 함

    입력: food = [1, 3, 4, 6] -> "1223330333221"
        food[0]: 물, 항상 1
        food[i]: i번 음식의 수, 짝수가 아니면 1개 버린다, i가 작을수록 칼로리가 낮음
*/

class Solution {
	public String solution(int[] food) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < food.length; i++) {
			sb.append(String.valueOf(i).repeat(food[i] / 2));
		}

		sb.append(0);

		for (int i = food.length - 1; i > 0; i--) {
			sb.append(String.valueOf(i).repeat(food[i] / 2));
		}

		return sb.toString();
	}
}
