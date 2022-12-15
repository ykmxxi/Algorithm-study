package lv1self.음수양수더하기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/76501
    - 음양 더하기
        어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes 와 이 정수들의 부호를 차례대로 담은
        boolean 배열 signs 가 매개변수로 주어짐. 실제 정수들의 합을 구하여 return 하도록 함수를 완성

        * absolutes 의 길이는 1 이상 1,000 이하
            * absolutes 의 모든 수는 각각 1 이상 1,000 이하
        * signs 의 길이는 absolutes 의 길이와 같다
            * signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수, 그렇지 않으면 음수

 */


public class Lv1_76501 {

    int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int[] arr = new int[absolutes.length];

        for (int i = 0; i < absolutes.length; i++) {

            if (signs[i]) {
                arr[i] = absolutes[i];

            } else {
                arr[i] = -(absolutes[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Lv1_76501 lv1_76501 = new Lv1_76501();
        int[] absolutes = {1, 2, 3};
        boolean[] signs = {false, false, true};

        int answer = lv1_76501.solution(absolutes, signs);
        System.out.println(answer);

    }
}

