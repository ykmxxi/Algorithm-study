package 완전탐색.n과m1번;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected;
    static int[] used; // 1 이면 사용한 수, 0 이면 사용하지 않은 수

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
        used = new int[N + 1];
    }

    // N개 중 중복 없이 M개를 순서 있게 나열
    static void rec_func(int k) {
        if (k == M + 1) { // M개의 숫자를 모두 배열에 저장 했으면 출력
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int candidate = 1; candidate <= N; candidate++) {
                if (used[candidate] == 1) { // 사용한 수는 넘어가
                    continue;
                }
                // k 번 째에 candidate 가 올 수 있으면
                selected[k] = candidate;
                used[candidate] = 1; // 숫자 사용

                rec_func(k + 1);

                // 초기화
                selected[k] = 0;
                used[candidate] = 0;
            }
        }

    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
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
