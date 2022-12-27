package ch02;

import java.util.Scanner;

// 키를 입력받아 저장하고, 배열 요소의 최대값을 출력
public class MaxOfArray {
    public static void main(String[] args) {
        int[] heights;
        Scanner scanner = new Scanner(System.in);

        System.out.println("키의 최대값을 구합니다.");
        System.out.print("사람 수를 입력하세요: ");
        int num = scanner.nextInt();
        heights = new int[num];

        for (int i = 0; i < heights.length; i++) {
            System.out.print("heights[" + i + "]: ");
            heights[i] = scanner.nextInt();
        }

        System.out.println("가장 큰 사람의 키는 " + getMax(heights) + "cm 입니다.");
    }

    public static int getMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
