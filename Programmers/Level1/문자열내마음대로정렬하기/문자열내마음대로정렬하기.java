package level1.문자열내마음대로정렬하기;

/*
	https://school.programmers.co.kr/learn/courses/30/lessons/12915
    문자열 배열 strings, 정수 n
    인덱스 n번째 글자를 기준으로 오름차순 정렬
    같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치
*/

import java.util.*;

class Solution {
	static int index;

	static class Word implements Comparable<Word> {
		public String str;

		public Word(String str) {
			this.str = str;
		}

		public int compareTo(Word other) {
			if (this.str.charAt(index) != other.str.charAt(index)) {
				return this.str.charAt(index) - other.str.charAt(index);
			}
			return this.str.compareTo(other.str);
		}

	}

	public String[] solution(String[] strings, int n) {
		String[] answer = {};
		Word[] w = new Word[strings.length];
		index = n;

		for (int i = 0; i < strings.length; i++) {
			w[i] = new Word(strings[i]);
		}

		Arrays.sort(w);
		answer = new String[w.length];

		for (int i = 0; i < w.length; i++) {
			answer[i] = w[i].str;
		}
		return answer;
	}
}
