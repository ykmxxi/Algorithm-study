package 완전탐색.연산자끼워넣기;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, max, min;
    static int[] nums, operators; // nums: 수열 저장 배열, operators: 연산자 저장 배열

    static void input() {
        N = scan.nextInt(); // 첫째 줄 입력
        nums = new int[N + 1];
        operators = new int[5];

        // 둘째 줄 입력
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }

        // 셋째 줄 입력
        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) { // 덧셈
            return operand1 + operand2;
        } else if (operator == 2) { // 뺄셈
            return operand1 - operand2;
        } else if (operator == 3) { // 곱셈
            return operand1 * operand2;
        } else { // 나눗셈
            return operand1 / operand2;
        }
    }

    static void rec_func(int k, int value) {
        if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for (int candidate = 1; candidate <= 4; candidate++) {
                if (operators[candidate] >= 1) { // 1 이상이면 연산자 사용 가능
                    operators[candidate]--; // 연산자 사용
                    rec_func(k + 1, calculator(value, candidate, nums[k + 1]));

                    // 재귀를 통해 식이 완성되면 다시 값을 초기화
                    operators[candidate]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
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
