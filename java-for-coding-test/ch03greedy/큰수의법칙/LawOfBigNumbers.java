package ch03greedy.큰수의법칙;

import java.util.Arrays;
import java.util.Scanner;

public class LawOfBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0; // 배열의 크기
        int m = 0; // 더하는 횟수
        int k = 0; // 중복 횟수
        long answer = 0L;

        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr); // 정렬

        for (int i = 1; i <= m; i++) {
            if (k % i == 0) { // k번 반복 덧셈시 두 번째 큰 수 더하기
                answer += arr[n - 2];
            } else {
                answer += arr[n - 1]; // k번 제일 큰 수 더하기
            }

        }
        /*
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int answer = 0;
        answer += cnt * first; // 가장 큰 수 더하기
        answer += (m - cnt) * second; // 두 번째로 큰 수 더하기
         */
        System.out.println(answer);

    }
}
