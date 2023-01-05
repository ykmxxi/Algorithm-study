package ch03greedy._1이될때까지;

import java.util.Scanner;

public class MakeOne {
    public static void main(String[] args) {
        int n = 0;
        int k = 0;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int answer = 0;

/*
        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;
            answer += (n - target);
            n = target;

            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) {
                break;
            }

            // K로 나누기
            answer += 1;
            n /= k;
        }
        answer += (n - 1); // 마지막으로 남은 수에 대하여 1씩 빼기
 */

        while (true) {
            if (n == 1) {
                break;
            }
            if (n % k == 0) {
                n /= k;
                answer++;
            }
            if (n % k != 0) {
                n -= 1;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
