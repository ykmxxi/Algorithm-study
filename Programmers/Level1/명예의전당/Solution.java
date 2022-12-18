package lv1self.명예의전당;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<Integer> scores = Arrays.stream(score)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < scores.size(); i++) {
            tmp.add(scores.get(i));
            tmp.sort(Comparator.reverseOrder());
            if (i < k) {
                answer.add(tmp.get(i));
            }
            if (i >= k) {
                answer.add(tmp.get(k - 1));
            }
        }
        return answer;
    }
}
