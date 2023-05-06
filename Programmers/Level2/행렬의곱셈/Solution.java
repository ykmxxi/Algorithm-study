package level2.행렬의곱셈;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12949

    행렬의 곱셈
    arr1(A x B) * arr2(B x C) = A x C 배열
*/

class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int row = arr1.length;
		int col = arr2[0].length;
		int[][] answer = new int[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {
				for (int k = 0; k < arr1[0].length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		return answer;
	}
}
