package lv2.더맵게;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42626

    # 더 맵게
    - 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶다
    - 스코빌 지수가 가장 낮은 두 개의 음식을 섞어 새로운 음식을 만든다
    - 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    - 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞는다
    - 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return

    ## 제한 사항
    - scoville 의 길이는 2 이상 1,000,000 이하
    - K 는 0 이상 1,000,000,000 이하
    - scoville 의 각 원소는 0 이상 1,000,000 이하
    - 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우 -1을 return
*/

import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int num : scoville) {
			pq.add(num);
		}

		while (true) {
			if (pq.size() == 1 && pq.peek() < K) {
				answer = -1;
				break;
			}
			if (pq.peek() >= K) { // 스코빌 지수가 가장 낮은 음식이 K 이상이면 stop
				break;
			}

			int sum = pq.poll() + pq.poll() * 2;
			pq.add(sum);
			answer++;
		}

		return answer;
	}
}
