package lv1self.문자열내p와y개수;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12916
    * 문자열 내 p와 y의 개수
    대문자와 소문자가 섞여있는 문자열 s가 주어짐. s 에 'p' 의 개수와 'y'의 개수를 비교해 같으면 True,
    다르면 False 를 return.
    'p', 'y' 모두 하나도 없는 경우는 항상 True, 단 개수를 비교할 때 대문자와 소문자는 구별하지 않음
        - 문자열 s의 길이 : 50 이하의 자연수
        - 문자열 s는 알파벳으로만 이루어짐
 */

public class CountPAndY {

    boolean solution(String s) {
        boolean answer = true;
        String[] arr = s.split("");
        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i]).equals("p") || (arr[i]).equals("P"))
                pCount += 1;
            if ((arr[i]).equals("y") || (arr[i]).equals("Y"))
                yCount += 1;
        }

        if (pCount == yCount) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "pyy";

        CountPAndY countPAndY = new CountPAndY();
        System.out.println(countPAndY.solution(s));

    }

}
