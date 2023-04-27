package level1.수포자;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42840

    1번 수포자: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, ... 5개 반복
    2번 수포자: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, ... 8개 반복
    3번 수포자: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, ... 10개 반복

    answers가 주어졌을 때 가장 많이 맞춘 사람을 return
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int[] answers) {
		int[] first = {1, 2, 3, 4, 5};
		int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] score = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == first[i % 5]) {
				score[0]++;
			}

			if (answers[i] == second[i % 8]) {
				score[1]++;
			}

			if (answers[i] == third[i % 10]) {
				score[2]++;
			}
		}

		// 최대 점수 구하기
		int max = Math.max(score[0], Math.max(score[1], score[2]));

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < score.length; i++) {
			if (max == score[i]) {
				list.add(i + 1);
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
