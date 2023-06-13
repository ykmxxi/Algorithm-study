package 정렬.카드;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] nums;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
    }

    static void pro() {
        // 입력받은 카드 정수 배열 정렬
        Arrays.sort(nums, 1, N + 1);

        // count
        long answer = nums[1];
        int count = 1; // 현재 정답의 빈도 수
        int curCount = 1; // 현재 선택된 요소의 빈도 수

        for (int i = 2; i <= N; i++) {
            if (nums[i] == nums[i - 1]) {
                curCount++;
            }

            if (nums[i] != nums[i - 1]) {
                curCount = 1;
            }

            if (curCount > count) {
                count = curCount;
                answer = nums[i];
            }
        }
        sb.append(answer);

        // 정답 출력
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
