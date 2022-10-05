package lv1self;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12910
    * 나누어 떨어지는 숫자 배열
        array 의 각 element 중 divisor 로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환
        divisor 로 나누어 떨어지는 element 가 하나도 없다면 배열에 -1을 담아 반환
            - arr 은 자연수를 담은 배열
            - 정수 i, j 에 대해 i != j 이면 arr[i] != arr[j]
            - divisor 는 자연수
            - array 는 길이가 1 이상인 배열

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv1_12910 {

    int[] Solution(int[] array, int divisor) {

        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % divisor == 0) {
                list.add(array[i]);
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        Collections.sort(list);

        answer = new int[list.size()];
        answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {

        int[] array1 = {5, 9, 7, 10};
        int[] array2 = {2, 36, 1, 3};
        int[] array3 = {3, 2, 6};

        Lv1_12910 lv1_12910 = new Lv1_12910();
        System.out.println(Arrays.toString(lv1_12910.Solution(array1, 5)));
        System.out.println(Arrays.toString(lv1_12910.Solution(array2, 1)));
        System.out.println(Arrays.toString(lv1_12910.Solution(array3, 10)));
    }
}
