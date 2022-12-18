package lv1self.가운데글자가져오기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12903
    * 가운데 글자 가져오기

        * 문제 설명
            단어 s의 가운데 글자를 반환하는 함수, 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다

        * 제한 사항
            - s는 길이가 1 이상, 100 이하인 String

 */

public class GetMiddleChar {

    String solution(String s) {
        String answer = "";
        int length = s.length();

        if (length % 2 == 1) {
            answer = "" + s.charAt(length / 2);
        } else {
            answer = s.substring(length/2-1, length/2 + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        GetMiddleChar getMiddleChar = new GetMiddleChar();
        System.out.println(getMiddleChar.solution("abcde"));
        System.out.println(getMiddleChar.solution("qwer"));


    }
}
