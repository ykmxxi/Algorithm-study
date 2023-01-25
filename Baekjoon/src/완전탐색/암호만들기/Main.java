package 완전탐색.암호만들기;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        L = scan.nextInt();
        C = scan.nextInt();
        alphabets = new char[C + 1];
        selected = new int[L + 1];

        String[] tokens = scan.nextLine().split(" "); // 공백을 구분자로 입력
        for (int i = 1; i <= C; i++) {
            alphabets[i] = tokens[i - 1].charAt(0);
        }
    }

    static int L;
    static int C;
    static char[] alphabets;
    static int[] selected;

    static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    static void rec_func(int k) {
        if (k == L + 1) { // L개의 암호문 완성 시
            int vowelCount = 0; // 모음 개수
            int consonantCount = 0; // 자음 개수

            for (int i = 1; i <= L; i++) {
                if (isVowel(alphabets[selected[i]])) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
            if (vowelCount >= 1 && consonantCount >= 2) {
                for (int i = 1; i <= L; i++) {
                    sb.append(alphabets[selected[i]]);
                }
                sb.append('\n');
            }
        } else {
            for (int candidate = selected[k - 1] + 1; candidate <= C; candidate++) {
                selected[k] = candidate;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(alphabets, 1, C + 1);
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