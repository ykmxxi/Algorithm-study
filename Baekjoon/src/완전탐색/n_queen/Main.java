package 완전탐색.n_queen;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int ans;
    static int[] col;


    // 입력값 처리 함수
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        ans = 0;
        col = new int[N + 1];
    }

    static boolean canAttack(int r1, int c1, int r2, int c2) {
        if (c1 == c2) { // 같은 열에 있으면 수평 공격 가능
            return true;
        }

        // 대각선 공격
        if (r1 - c1 == r2 - c2) { // 우하향 대각선 공격 가능
            return true;
        }
        if (r1 + c1 == r2 + c2) { // 우상향 대각선 공격 가능
            return true;
        }
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) { // 각 행마다 퀸을 모두 놓은 경우
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                // valid check (row, c)
                for (int i = 1; i <= row - 1; i++) {
                    if (canAttack(row, c, i, col[i])) { // 현재 후보군 (row, c), 이전 후보군(i, col[i])
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);

                    // 재귀 호출 종료 후 초기화
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}
