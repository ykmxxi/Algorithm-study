package 이분탐색.두수의합;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, x;
    static int[] A;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
    }

    static boolean binary_search(int[] A, int L, int R, int X) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == X) {
                return true;
            }

            if (A[mid] < X) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    static void pro() {
        // A 이분 탐색을 위한 정렬
        Arrays.sort(A, 1, n + 1);

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (binary_search(A, i + 1, n, x - A[i])) { // X(기대값): 목표값 - 현재 원소
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
