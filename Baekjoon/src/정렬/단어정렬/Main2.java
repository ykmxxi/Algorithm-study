package 정렬.단어정렬;

// HashMap을 이용한 풀이
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main2 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<String, Integer> words;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        words = new HashMap<>(N);

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.put(word, word.length());
        }
    }

    static void pro() {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(words.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o1.getValue() - o2.getValue();
        });

        for (Entry<String, Integer> entries : list) {
            sb.append(entries.getKey()).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
