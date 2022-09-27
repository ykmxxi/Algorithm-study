package lv1;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12944
    * 정수를 담고 있는 배열 arr 의 평균값을 return 하는 함수 작성
        - arr 은 길이 1 이상, 100 이하인 배열
        - arr 의 원소는 -10,000 이상 10,000 이하인 정수
 */
public class CalcAverage {

    double solution(int[] arr) {
        double answer = 0;
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        answer = sum / arr.length;
        return answer;
    }

    public static void main(String[] args) {
        CalcAverage calcAverage = new CalcAverage();
        int[] arr = {1, 2, 3, 4};

        System.out.println(calcAverage.solution(arr));
    }
}
