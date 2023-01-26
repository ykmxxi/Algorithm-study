package 정렬.파일정리;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] input;
    static String[] types;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new String[N];
        types = new String[N];

        for (int i = 0; i < N; i++) {
            types[i] = br.readLine().split("\\.")[1];
        }
    }

    static void pro() {
        Arrays.sort(types);

        int count = 1;
        for (int i = 1; i < N; i++) {
            if (types[i].equals(types[i - 1])) {
                count++;
                if (i == N - 1) {
                    sb.append(types[i]).append(' ').append(count).append('\n');
                }
            } else {
                sb.append(types[i - 1]).append(' ').append(count).append('\n');
                count = 1;
                if (i == N - 1) {
                    sb.append(types[i]).append(' ').append(1).append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
