package lv2.튜플;

  /*
    https://school.programmers.co.kr/learn/courses/30/lessons/64065

    # 튜플
    - 튜플: 셀수있는 수량의 순서있는 열겨 또는 순서를 따르는 요소들의 모음
    - n개의 요소를 가진 튜플을 n-튜플 이라 하고 다음과 같이 표현할 수 있다
        - (a1, a2, a3, ..., an)
    - 튜플의 성질
        1. 중복된 원소가 있을 수 있다, (2, 3, 1, 2)
        2. 원소에 정해진 순서가 있으며, 순서가 다르면 서로 다른 튜플, (1, 2, 3) != (1, 3, 2)
        3. 튜플의 원소 개수는 유한
    - 원소의 개수가 n개, 중복되는 원소가 없는 튜플이 주어질 때 이는 다음과 같이 집합 기호를 이용해 표현할 수 있다
        - {{a1}, {a1, a2}, {a1, a2, a3}, ... {a1, a2, a3, ..., an}}
    - 특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return

    ## 제한사항
    - s의 길이는 5 이상 1,000,000 이하 -> int
    - s는 숫자와 '{', '}', ',' 로만 이루어짐
    - 숫자가 0으로 시작하는 경우는 없다, 03 or 010 -> x
    - s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있다
    - s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수
    - return 하는 배열의 길이는 1 이상 500 이하인 경우만 입력으로 주어진다
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

class Solution {
	public int[] solution(String s) {
		List<Integer> list = new ArrayList<>();
		HashSet<Integer> hashSet = new HashSet<>();
		String[] arr = s.split("[{}]");

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (String str : arr) {
			if (str.equals("")) {
				continue;
			}
			if (str.equals(",")) {
				continue;
			}

			String[] splited = str.split(",");
			for (String num : splited) {
				int n = Integer.parseInt(num);
				if (hashSet.add(n)) {
					list.add(n);
				}
			}
		}

		return list.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
