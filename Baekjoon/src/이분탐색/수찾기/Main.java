package 이분탐색.수찾기;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        while (L <= R) {
            int mid = (L + R) / 2;

            if (A[mid] == X) {
                return 1;
            }
            if (A[mid] < X) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return 0;
    }

    static void pro() {
        // 이분 탐색을 위해 A 배열 정렬
        Arrays.sort(A, 1, N + 1);

        // B[1]을 기준값 X로 두고 A 배열 이분 탐색 시작
        int L = 1;
        int R = N;

        for (int i = 1; i <= M; i++) {
            int answer = lower_bound(A, L, R, B[i]);
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
