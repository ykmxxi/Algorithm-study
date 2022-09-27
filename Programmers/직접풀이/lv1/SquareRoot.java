package lv1;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12934
    * 정수 제곱근 판별
    임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
    n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수
        - n은 1이상, 50000000000000 이하인 양의 정수입니다.
        Ex) 121은 양의 정수 11의 제곱이므로 (11+1)를 제곱한 144를 리턴
            3은 양의 정수의 제곱이 아니므로, -1을 리턴

 */
public class SquareRoot {

    long solution(long n) {
        long answer = 0;

        if (Math.sqrt(n) == (int) (Math.sqrt(n))) {
            answer = (long) Math.pow((Math.sqrt(n) + 1), 2);
        } else
            answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        int n = 121;
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.solution(n));

    }
}

