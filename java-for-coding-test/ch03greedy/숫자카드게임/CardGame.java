package ch03greedy.숫자카드게임;

import java.util.Arrays;
import java.util.Scanner;

public class CardGame {
    static int n = 0; // 행
    static int m = 0; // 열

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[][] cards = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                cards[row][col] = scanner.nextInt();
            }
        }

        int[] minArr = getMinimums(cards);
        Arrays.sort(minArr);
        int answer = minArr[n - 1];
        System.out.println(answer);
    }

    /**
     * 각 행의 가장 작은 수를 찾는 메서드
     *
     * @return min
     */
    public static int[] getMinimums(int[][] cards) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            Arrays.sort(cards[i]);
            arr[i] = cards[i][0];
        }
        return arr;
    }
}
