package lv1self.문자열다루기기본;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12918
    프로그래머스 Lv1 12918번: 문자열 다루기 기본
 */

import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        String numberRegEx = "^[0-9]{4}$|^[0-9]{6}$";
        return Pattern.matches(numberRegEx, s);
    }
}
