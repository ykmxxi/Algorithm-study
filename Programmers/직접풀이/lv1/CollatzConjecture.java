package lv1;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12943
    * 콜라츠 추측
    1-1. 입력된 수가 짝수라면 2로 나눈다
    1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더한다
    2. 결과로 나온 수에 같은 작업을 1이 될때까지 반복
    ex) 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    단, 주어진 수가 1인 경우에는 0을, 작업을 500번 반복할 때까지 1이 되지 않는다면 -1을 반환
        - num 은 1 이상 8,000,000 미만인 정수
 */
public class CollatzConjecture {

    int solution(int num) {
        long n = num;
        int answer = 0;

        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            answer++;

            if (answer >= 500) {
                answer = -1;
                break;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        CollatzConjecture collatzConjecture = new CollatzConjecture();
        System.out.println(collatzConjecture.solution(6));
        System.out.println(collatzConjecture.solution(16));
        System.out.println(collatzConjecture.solution(626331));

    }
}
