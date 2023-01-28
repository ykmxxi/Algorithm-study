package 이분탐색.나무자르기;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 나무의 수, 필요한 나무의 길이
    static int[] A; // 나무 높이들의 배열

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static boolean determination(int H) {
        // TODO: H 높이로 잘랐을 때, M 만큼 얻을 수 있으면 true, 불가능하면 false
        long sum = 0L;

        for (int i = 1; i <= N; i++) {
            if (A[i] > H) {
                sum += A[i] - H;
            }
        }

        return sum >= M;
    }

    static void pro() {
        long L = 0L;
        long R = 2000000000;
        long answer = 0L;

        // TODO: 이분 탐색을 이용해 최적값 검색
        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination((int) mid)) { // M 만큼 얻어올 수 있으면
                answer = mid; // 정답 갱신
                L = mid + 1; // 구간 갱신
            } else {
                R = mid - 1;
            }
        }

        sb.append(answer);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
