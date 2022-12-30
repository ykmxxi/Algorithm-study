package lv1self.같은숫자는싫어;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12906
    - 프로그래머스 Lv1: 같은 숫자는 싫어(12906 번)
        - 배열 arr이 주어질 때, 각 원소는 숫자 0부터 9까지로 이루어짐.
        - 이때 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거
        - 제거된 후 남을 수를 반환할 때는 배열 arr의 순서를 유지해야함
        - ex: arr = [1, 1, 3, 3, 0, 1, 1] return [1, 3, 0, 1]
 */

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static int[] solution(int[] arr) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                stack.push(arr[i]);
            }
        }

        answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
