package lv1self.약수의합;

/*

    https://school.programmers.co.kr/learn/courses/30/lessons/12928
    * 약수의 합
    정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수
        - n 은 0 이상 3000 이하인 정수

 */
import java.util.ArrayList;

public class SumOfDivisor {

    int solution(int n) {
        int answer = 0;
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                answer += i;
            }
        }
        System.out.print(n + "의 약수는 ");
        for (int i = 0; i < divisors.size(); i++) {
            if (i == divisors.size() - 1) {
                System.out.print(divisors.get(i) + "입니다.");
            } else {
                System.out.print(divisors.get(i) + ", ");
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int n1 = 12;
        int n2 = 5;

        SumOfDivisor sumOfDivisor = new SumOfDivisor();

        int answer1 = sumOfDivisor.solution(n1);
        System.out.print(" 이를 모두 더하면 " + answer1 + "입니다.");
        System.out.println();
        int answer2 = sumOfDivisor.solution(n2);
        System.out.print(" 이를 모두 더하면 " + answer2 + "입니다.");
    }
}
