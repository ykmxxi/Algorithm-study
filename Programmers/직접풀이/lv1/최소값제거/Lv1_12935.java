package lv1self.최소값제거;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12935
    * 제일 작은 수 제거하기
        정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수 완성
        단, 리턴하는 배열이 빈 배열인 경우 -1을 채워 리턴
        ex) [4, 3, 2, 1] -> [4, 3, 2] 리턴
            [10] -> [-1] 리턴

            - arr 은 길이 1 이상인 배열
            - 인덱스 i, j 에 대해 i != j 이면 arr[i] != arr[j]

 */

import java.util.Arrays;

public class Lv1_12935 {

    int[] solution(int[] array) {

        int[] answer = new int[array.length - 1];
        int minIndex = 0;
        int min = array[0];

        if (array.length == 1) {
            answer = new int[]{-1};
        } else {

            for (int i = 0; i < array.length; i++) {

                if (min > array[i]) {
                    min = array[i];
                    minIndex = i;
                }
            }

            System.arraycopy(array, 0, answer, 0, minIndex);
            System.arraycopy(array, minIndex + 1, answer, minIndex, array.length - minIndex - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array1 = {11, 43, 32, 1, 7, 10};
        int[] array2 = {10};

        Lv1_12935 lv1_12935 = new Lv1_12935();

        System.out.println(Arrays.toString(lv1_12935.solution(array1)));
        System.out.println(Arrays.toString(lv1_12935.solution(array2)));
    }
}
