package lv1self;

/*

    https://school.programmers.co.kr/learn/courses/30/lessons/86051
    * 없는 숫자 더하기
        0 부터 9 까지의 숫자 중 일부가 들어있는 정수 배열 numbers 가 매개변수로 주어짐.
        numbers 에서 찾을 수 없는 0 부터 9 까지의 숫자를 모두 찾아 더한 수를 return

            * 1 <= numbers.length <= 9
            * numbers 의 모든 원소는 0 이상 9 이하 숫자
            * numbers 의 모든 원소는 서로 다르다

 */

public class Lv1_86051 {


    int solution(int[] numbers) {

        int answer = -1;
        int total = 45;     // 0 ~ 9 까지의 총 합

        for (int i = 0; i < numbers.length; i++) {
            total -= numbers[i];
        }

        answer = total;

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6, 7, 8, 0};

        Lv1_86051 lv1_86051 = new Lv1_86051();
        System.out.println(lv1_86051.solution(arr));

    }
}
