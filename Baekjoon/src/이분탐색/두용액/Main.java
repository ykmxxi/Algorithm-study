package 이분탐색.두용액;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 R + 1 을 return 한다

        int result = R + 1;  // 만약 A[L...R] 중
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return result;
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int s1 = 0;
        int s2 = 0;

        for (int left = 1; left <= N - 1; left++) {
            // 왼쪽 용액 A[left]를 골랐을 때 0에 가까운 값은 -A[left]와 가장 가까운 값을 찾는게 빠르다.
            // left + 1 부터 N 까지 -A[left]와 가장 가까운 값을 찾기
            int candidate = lower_bound(A, left + 1, N, -A[left]);

            // A[candidate - 1] 와 A[candidate] 중에 A[left] 와 섞었을 때의 정보를 정답에 갱신시킨다.

            // 1. A[left] + A[candidate - 1]
            if (left < candidate - 1 && Math.abs(A[left] + A[candidate - 1]) < best_sum) {
                best_sum = Math.abs(A[left] + A[candidate - 1]);
                s1 = A[left];
                s2 = A[candidate - 1];
            }

            // 2. A[left] + A[candidate]
            if (candidate <= N && Math.abs(A[left] + A[candidate]) < best_sum) {
                best_sum = Math.abs(A[left] + A[candidate]);
                s1 = A[left];
                s2 = A[candidate];
            }

        }
        sb.append(s1).append(' ').append(s2);
        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
