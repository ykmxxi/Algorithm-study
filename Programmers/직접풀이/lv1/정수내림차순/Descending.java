package lv1self.정수내림차순;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12933
    * 정수 내림차순으로 배치하기
    함수 solution 은 정수 n 을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한
    새로운 정수를 리턴. ex) 118372 -> 873211
        - n 은 1 이상 8,000,000,000
 */

import java.util.*;

public class Descending {

    long solution(long n) {
        long answer = 0;
        String str = Long.toString(n);
        long[] arr = new long[str.length()];
        int index = 0;

        while (n != 0) {
            arr[index] = n % 10;
            n /= 10;
            index++;
        }

        Arrays.sort(arr);

        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            long temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }


        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            answer += (arr[i] * Math.pow(10, j));

        }
        return answer;
    }

    public static void main(String[] args) {
        long n = 118372;
        Descending descending = new Descending();
        System.out.println(descending.solution(n));

    }
}
