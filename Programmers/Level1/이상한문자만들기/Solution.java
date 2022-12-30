package lv1self.이상한문자만들기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12930
    - 프로그래머스 Lv1 12930: 이상한 문자 만들기
        - 문자열 s는 한 개 이상의 단어로 구성
        - 각 단어는 하나 이상의 공백문자로 구분
        - 각 단어의 짝수번째는 대문자, 홀수번째는 소문자
        - 홀짝 구분은 각 단어별로 판단
        - Ex: "try hello world" -> "TrY HeLlO WoRlD"
 */

public class Solution {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ", -1);

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (j % 2 == 0) {
                    answer.append(Character.toUpperCase(word.charAt(j)));
                }
                if (j % 2 == 1) {
                    answer.append(Character.toLowerCase(word.charAt(j)));
                }
            }
            answer.append(" ");
        }

        answer.deleteCharAt(answer.length() - 1);
        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "      TR y    y ";
        System.out.println(solution(s));
    }

}
