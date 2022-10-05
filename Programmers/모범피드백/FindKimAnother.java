package lv1another;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12919
    * 서울에서 김서방 찾기
    String 형 배열 seoul 의 element 중 "Kim"의 위치를 찾아, "김성방은 x에 있다" 문자열 반환
    "Kim"은 오직 한 번만 나타나면 잘못된 값이 입력되는 경우는 없음
        - seoul 의 길이 1 이상, 1000 이하인 배열
        - seoul 의 원소는 길이 1 이상, 20 이하인 문자열
        - "Kim"은 반드시 seoul 안에 포함
 */

public class FindKimAnother {

    String solution(String[] seoul) {

        int x = 0;

        for (String name : seoul) {
            if (name.equals("Kim"))
                break;
            x++;
        }

        return "김서방은 " + x + "에 있다";

    }

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Park", "Ki", "Kim", "Yun"};
        FindKimAnother findKimAnother = new FindKimAnother();
        System.out.println(findKimAnother.solution(seoul));
    }
}
