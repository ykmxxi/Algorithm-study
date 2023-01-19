package lv1self.최소직사각형;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/86491
    - 프로그래머스 Lv1 86491번: 최소직사각형

    - 문제 설명
        - 주어진 명함 [가로, 세로]이 모두 들어갈 수 있는 직사각형 크기를 계산
        - 가로로 눕혀 수납 가능

    - 제한사항
        - sizes의 길이는 1 이상 10,000 이하
        - w는 가로 길이, h는 세로 길이
            - w와 h는 1 이상 1,000 이하 자연수
 */

public class MinRectangle {

    public static int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int tmpWidth = Math.max(size[0], size[1]);
            int tmpHeight = Math.min(size[0], size[1]);

            if (tmpWidth > maxWidth) {
                maxWidth = tmpWidth;
            }
            if (tmpHeight > maxHeight) {
                maxHeight = tmpHeight;
            }
        }
        return maxWidth * maxHeight;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes)); // 4,000
    }
}
