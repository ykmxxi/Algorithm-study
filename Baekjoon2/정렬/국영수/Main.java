package 정렬.국영수;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] students;

    static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            if (korean != other.korean) { // 국어 내림차순
                return other.korean - korean;
            }
            if (english != other.english) { // 영어 오름차순
                return english - other.english;
            }
            if (math != other.math) { // 수학 내림차순
                return other.math - math;
            }
            return name.compareTo(other.name); // 이름 오름차순
        }

    }

    static void input() {
        N = scan.nextInt();
        students = new Elem[N];
        for (int i = 0; i < N; i++) {
            students[i] = new Elem();
            students[i].name = scan.next();
            students[i].korean = scan.nextInt();
            students[i].english = scan.nextInt();
            students[i].math = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(students);
        for (int i = 0; i < N; i++) {
            sb.append(students[i].name).append('\n');
        }
    }

    public static void main(String[] args) {
        input();
        pro();
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