package 정렬.단어정렬;

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[] words;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
    }

    static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1.length() != s2.length()) { // 길이가 다르면
                return s1.length() - s2.length(); // 짧은 것 부터 오름차순
            }
            return s1.compareTo(s2); // 길이가 같으면 사전 순
        }
    }

    static void pro() {
        Arrays.sort(words, new MyComparator());
        for (int i = 0; i < N; i++) {
            if (i == 0 || words[i].compareTo(words[i - 1]) != 0) { // 처음 원소 or 중복된 단어가 아니라면
                sb.append(words[i]).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
