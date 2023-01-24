package 완전탐색.부분수열의합;

import java.util.*;
import java.io.*;

public class Main {
    static int N, S, ans;
    static int[] nums;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        S = scan.nextInt();
        ans = 0;
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    // k번 째 원소를 포함시킬 지 정하는 함수
    // value: k-1번 째까지 골라진 원소들의 합
    static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (value == S) {
                ans++;
            }
        } else {
            // k번 째 원소를 포함시킬 지 결정하고 재귀호출
            rec_func(k + 1, value + nums[k]); // k번 째 원소를 포함시키는 경우
            rec_func(k + 1, value); // k번 째 원소를 포함시키지 않는 경우
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        // ans 가 정말 "진 부분집합"만 다루는 지 확인
        if (S == 0) { // 목표값이 0 이면 공집합을 부분수열로 추가하기 때문에 크기가 양수인 부분수열 조건에 위배되므로 빼주기
            ans--;
        }
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
