package lv1self.문자열내림차순으로배치;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12917
    * 문자열 내림차순으로 배치하기
        문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수
        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

        제한사항
            - s는 길이 1 이상인 문자열입니다.
 */

import java.util.Arrays;

public class StringDescending {

    String solution(String s) {
        String answer = "";

        char[] chars = s.toCharArray();
        char[] arr = new char[s.length()];
        Arrays.sort(chars);

        for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = chars[i];
        }

        answer = String.valueOf(arr);

        return answer;

    }

    public static void main(String[] args) {

        String s = "Zbcdefg";
        StringDescending stringDescending = new StringDescending();
        System.out.println(stringDescending.solution(s));

    }
}
