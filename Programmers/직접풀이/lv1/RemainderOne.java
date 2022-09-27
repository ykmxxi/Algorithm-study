package lv1;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/87389
    * 나머지가 1이 되는 수 찾기
    자연수 n이 매개변수로 주어진다. n 을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return
    답이 항상 존재함은 증명될 수 있다
        - 3 <= n <= 1,000,000
        ex) n = 10 -> result = 3, n = 12 -> result = 11
 */

public class RemainderOne {

    int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        RemainderOne remainderOne = new RemainderOne();
        System.out.println(remainderOne.solution(10));
        System.out.println(remainderOne.solution(12));

    }
}
