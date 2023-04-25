package level2;

/*
    s에는 공백으로 구분된 숫자들이 저장되어 있음.
    str에 나타나는 숫자 중 최소값과 최대값을 찾아 (최소값) (최대값) 형태의 문자열을 반환하는 문제
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
	public String solution(String s) {
		String answer = "";
		ArrayList<Integer> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0)).append(' ').append(list.get(list.size() - 1));

		return sb.toString();
	}
}
