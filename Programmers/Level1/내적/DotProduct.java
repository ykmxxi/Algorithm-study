package lv1self.내적;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/70128
    * 내적
        길이가 같은 두 1차원 정수 배열 a, b 가 매개변수로 주어집니다. a 와 b 의 내적을 return
        이때, a 와 b 의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1]

    * 제한사항
        - a, b의 길이는 1 이상 1,000 이하
        - a, b의 모든 수는 -1,000 이상 1,000 이하

 */

public class DotProduct {

    int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        DotProduct dotProduct = new DotProduct();
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};

        System.out.println(dotProduct.solution(a, b));
    }
}
