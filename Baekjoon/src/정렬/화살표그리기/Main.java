package 정렬.화살표그리기;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Elem implements Comparable<Elem> {
        public int position;
        public int color;

        @Override
        public int compareTo(Elem other) {
            if (color != other.color) {
                return color - other.color;
            }
            return position - other.position;
        }
    }

    static int N;
    static Elem[] dots;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dots = new Elem[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            dots[i] = new Elem();
            dots[i].position = Integer.parseInt(st.nextToken());
            dots[i].color = Integer.parseInt(st.nextToken());

        }
    }

    static void pro() {
        // TODO: 색깔 별로 오름차순 정렬 후 같은 색깔 내 position 오름차순 정렬
        Arrays.sort(dots, 1, N + 1);

        // TODO: 인접 요소만 살펴 최소값 구하기
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (i == 1) { // 맨 처음 요소
                answer += (dots[2].position - dots[1].position);
            } else if (i > 1 && i < N) {
                if (dots[i].color == dots[i - 1].color && dots[i].color == dots[i + 1].color) { // 인접 요소 모두 같은 색깔
                    answer += Math.min(dots[i].position - dots[i - 1].position,
                            dots[i + 1].position - dots[i].position);
                }
                if (dots[i].color == dots[i - 1].color && dots[i].color != dots[i + 1].color) { // 이전 요소만 같은 색깔
                    answer += dots[i].position - dots[i - 1].position;
                }
                if (dots[i].color == dots[i + 1].color && dots[i].color != dots[i - 1].color) { // 다음 요소만 같은 색깔
                    answer += dots[i + 1].position - dots[i].position;
                }
            } else { // 마지막 요소
                answer += (dots[N].position - dots[N - 1].position);
            }
        }

        // TODO: 최소값 덧셈 후 출력
        sb.append(answer);
        System.out.println(sb.toString());

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
