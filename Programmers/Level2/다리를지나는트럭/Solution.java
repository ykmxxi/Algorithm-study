package level2.다리를지나는트럭;

/* https://school.programmers.co.kr/learn/courses/30/lessons/42583
    - 일차선 다리를 정해진 순으로 모든 트럭이 건녀려할 때 필요한 최소 시간
    - bridge_length: 1초에 길이 1만큼 트럭이 지날 수 있음
    - weight: 다리가 버틸 수 있는 총 무게
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Integer> q = new LinkedList<Integer>(); // 현재 다리의 상태
		int curWeight = 0; // 다리를 건너는 트럭들의 무게 합

		for (int tw : truck_weights) {

			while (true) {
				if (q.isEmpty()) { // 다리가 비어있다면 다음 트럭 삽입
					q.add(tw);
					curWeight += tw;
					answer++;
					break;
				} else if (q.size() == bridge_length) { // 현재 다리에 트럭이 가득 차 있다면
					curWeight -= q.poll();
				} else { // 다리가 가득차지 않은 상태에서 트럭이 한 대라도 있으면
					if (curWeight + tw > weight) { // 다음 트럭이 최대 무게 초과
						q.add(0);
						answer++;
					} else { // 다음 트럭이 최대 무게 이내
						q.add(tw);
						curWeight += tw;
						answer++;
						break;
					}
				}
			}
		}

		//걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
		return answer + bridge_length;
	}

}

