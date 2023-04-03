package lv2.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    - 각 기능은 진도가 100%일 때 서비스에 반영 가능
    - 각 기능의 개발속도는 모두 다름
        기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
    - 배포되어야 하는 순서대로 작업의 진도가 적힌 배열: progresses
    - 각 작업의 개발 속도가 적힌 정수 배열: speeds
    - 각 배포마다 몇 개의 기능이 배포되는지를 return
        배포는 하루에 한 번만 할 수 있음, 하루의 끝에 이루어진다 가정
*/

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer;
		List<Integer> list = new ArrayList<>(); // 정답을 저장할 리스트

		Queue<Integer> p = new LinkedList<>(); // 작업의 현재 진척도 큐
		Queue<Integer> s = new LinkedList<>(); // 작업의 시간 큐

		for (int i = 0; i < progresses.length; i++) {
			p.add(progresses[i]);
			s.add(speeds[i]);
		}

		while (!p.isEmpty()) {
			int cnt = 0;

			for (int speed : s) {
				int cur = p.poll(); // 현재 작업의 진척도 가져오고 삭제 (FIFO 구조)
				p.add(cur + speed); // (현재 진척도 + 하루 진척도)를 현재 진척도 큐에 추가 (FIFO 구조)
			}

			// 만약 100이 넘으면
			if (p.peek() >= 100) {
				while (!p.isEmpty() && p.peek() >= 100) {
					cnt++;
					p.remove(); // 완료된 작업 제거
					s.remove(); // 완료된 작업의 속도 제거
				}
				list.add(cnt);
			}
		}

		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
