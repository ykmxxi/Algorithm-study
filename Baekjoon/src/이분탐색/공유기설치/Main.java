package 이분탐색.공유기설치;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, C; // 집의 개수, 공유기의 개수
    static int[] A; // 집의 좌표

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    static boolean determination(int distance) {
        // distance 만큼의 거리 차이를 둔다면 C 개 공유기를 설치할 수 있는가?

        // 제일 왼쪽 부터 설치 (Greedy)
        // D 만큼의 거리를 두면서 최대로 설치한 개수와 C를 비교
        int count = 1;
        int last = A[1];

        for (int i = 2; i <= N; i++) { // O(N)
            // A[i]에 설치하려고 할 때 가능한가?
            if (A[i] - last >= distance) {
                count++; // 공유기 설치 수 증가
                last = A[i]; // 마지막에 설치한 집 갱신
            }
        }
        return count >= C;
    }

    static void pro() {
        // 주어진 집의 좌표 배열 정렬
        Arrays.sort(A, 1, N + 1);

        int L = 1;
        int R = 1000000000;
        int answer = 0;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (determination(mid)) {
                answer = mid;
                L = mid + 1;
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
