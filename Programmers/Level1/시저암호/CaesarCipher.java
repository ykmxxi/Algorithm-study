package lv1self.시저암호;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12926
    - 프로그래머스 Lv1 12926번: 시저 암호

    - 문제 설명
        - 각 알파벳을 일정 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식
        - 입력값: "AB", 1 -> 1만큼 밀면 "BC"

    - 제한 조건
        - 공백은 밀어도 공백
        - 매개변수 s는 알파벳 소문자, 대문자, 공백으로만 이루어짐
        - s의 길이는 8,000이하
        - n은 1 이상, 25이하인 자연수
 */

public class CaesarCipher {
    public static String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append(' '); // 공백인 경우 그대로 append
            } else {
                if (Character.isUpperCase(s.charAt(i))) { // 대문자인 경우
                    int index = (((int) s.charAt(i) - 65) + n) % 26;
                    builder.append((char) (65 + index));
                }
                if (Character.isLowerCase(s.charAt(i))) { // 소문자인 경우
                    int index = (((int) s.charAt(i) - 97) + n) % 26;
                    builder.append((char) (97 + index));
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("a  B z", 4)); // "e  F d"
    }
}
