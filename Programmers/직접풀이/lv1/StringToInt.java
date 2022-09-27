package lv1;

import java.util.Arrays;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12925
    * 문자열을 정수로 바꾸기
    문자열 s를 숫자로 변환한 결과를 반환하는 함수
        - s의 길이는 1 이상 5 이하
        - s의 맨앞에는 부호(+, -)가 올 수 있음
        - s는 부호와 숫자로만 이루어져있음
        - s는 "0"으로 시작하지 않음
        ex) "1234" -> 1234, "-1234" -> -1234
 */
public class StringToInt {

    int solution(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        char[] copy;
        // case 1 : 부호+
        if (chars[0] == '+') {
            for (int i = 0; i < chars.length - 1; i++) {
                chars[i] = chars[i + 1];
            }
            copy = Arrays.copyOf(chars, chars.length - 1);
            answer = Integer.parseInt(String.valueOf(copy));
        }
        // case 2 : 부호-
        else if (chars[0] == '-') {
            for (int i = 0; i < chars.length - 1; i++) {
                chars[i] = chars[i + 1];
            }
            copy = Arrays.copyOf(chars, chars.length - 1);
            answer = -(Integer.parseInt(String.valueOf(copy)));

        }
        // case 3 : 부호x 양수
        else {
            answer = Integer.parseInt(String.valueOf(chars));
        }

        return answer;
    }

    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = "-1234";
        String str3 = "+1234";

        StringToInt stringToInt = new StringToInt();
        System.out.println(stringToInt.solution(str1));
        System.out.println(stringToInt.solution(str2));
        System.out.println(stringToInt.solution(str3));

    }
}
