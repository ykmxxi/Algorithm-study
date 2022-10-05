package lv1another;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12948
    * 핸드폰 번호 가리기
    전화번호가 문자열 phone_number 로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 * 으로 가린 문자열 리턴
        -phone_number 는 길이 4 이상, 20 이하인 문자열
 */
public class HidePhoneNumAno {

    String solution(String phone_number) {

        String answer = "";
        char[] ch = phone_number.toCharArray();

        for (int i = 0; i < ch.length - 4; i++) {
            ch[i] = '*';
        }

        answer = String.valueOf(ch);
        return answer;
    }

    public static void main(String[] args) {
        HidePhoneNumAno hidePhoneNum = new HidePhoneNumAno();
        System.out.println(hidePhoneNum.solution("01012345678"));
        System.out.println(hidePhoneNum.solution("0211113344"));

    }
}
