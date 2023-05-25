package lv2.땅따먹기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12913

    # 땅따먹기
    - 게임의 땅은 총 N행 4열로 이루어져 있다
    - 모든 칸에는 점수가 쓰여 있고, 1행부터 땅을 밟으며 한 행씩 내려올 때 4칸 중 한 칸만 밟아야 한다
    - 단, 한 행씩 내려올 때 같은 열을 연속해서 밟을 수 없다
    - 마지막 행까지 모두 내려왔을 때 얻을 수 있는 점수의 최대값을 return

    ## 제한 사항
    - N 은 100,000 이하의 자연수
    - 열의 개수는 4 이고, 땅은 2차원 배열로 주어짐
    - 점수: 100 이하의 자연수
*/

class Solution {

	int solution(int[][] land) {
		int answer = 0;
		int[][] Dy = new int[land.length][4];

		// 초기화
		for (int i = 0; i < 4; i++) {
			Dy[0][i] = land[0][i];
		}

		// 점화식
		// 현재 행에서 밟은 열의 최대값 = 이전 행에서 현재 밟은 열을 제외한 값중 최대값 + 현재 밟은 열의 점수
		for (int row = 1; row < land.length; row++) {
			Dy[row][0] = Math.max(Dy[row - 1][1], Math.max(Dy[row - 1][2], Dy[row - 1][3])) + land[row][0];
			Dy[row][1] = Math.max(Dy[row - 1][0], Math.max(Dy[row - 1][2], Dy[row - 1][3])) + land[row][1];
			Dy[row][2] = Math.max(Dy[row - 1][0], Math.max(Dy[row - 1][1], Dy[row - 1][3])) + land[row][2];
			Dy[row][3] = Math.max(Dy[row - 1][0], Math.max(Dy[row - 1][1], Dy[row - 1][2])) + land[row][3];
		}

		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, Dy[land.length - 1][i]);
		}

		return answer;
	}
}
