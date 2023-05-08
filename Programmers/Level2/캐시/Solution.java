package level2.캐시;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/17680

    - 도시 이름을 검색하면 해당 도시와 관련된 맛집 게시물들을 DB에서 읽어 보여주는 서비스
    - DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성

    # 입력 형식
    - 캐시 크기(cacheSize), 도시이름 배열(cities)
        - 캐시 크기는 정수, 0 <= cacheSize <= 30
        - cities는 문자열 배열로 최대 길이가 100,000
        - 각 도시이름은 영문자로 구성(대소문자 구분 X), 도시이름은 최대 20자
    # 조건
    - LUR 사용
        - 최근까지 적게 hit된 캐시데이터를 지우는 알고리즘
    - cache hit 일 경우: 실행시간 1
    - cache miss 일 경우: 실행시간 5
*/

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
	private static final int HIT_TIME = 1;
	private static final int MISS_TIME = 5;

	static class Cache<String, Integer> extends LinkedHashMap<String, Integer> {
		private final int capacity;

		public Cache(int capacity) {
			super(capacity, 0.75f, true);
			this.capacity = capacity;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
			return size() > capacity;
		}
	}

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		if (cacheSize == 0) {
			return cities.length * MISS_TIME;
		}

		Cache<String, Integer> store = new Cache<>(cacheSize);

		for (String city : cities) {
			String key = city.toUpperCase();

			if (store.containsKey(key)) { // cache hit
				store.get(key);
				answer += HIT_TIME;
			} else { // cache miss
				answer += MISS_TIME;
				store.put(key, 0);
			}
		}

		return answer;
	}
}
