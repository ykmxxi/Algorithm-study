package level1.신고결과받기;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/92334

    게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템
    - 각 유저는 한 번에 한 명의 유저를 신고할 수 있다.
        - 신고 횟수는 제한이 없음. 서로 다른 유저를 계속해서 신고할 수 있음
        - 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리
    - k번 이상 신고된 유저는 게시판 이용이 정지, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
        - 신고 내용을 모두 취합해 마지막에 한꺼번에 이용 정지를 시키면서 메일을 발송

    - 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

	static class User {
		String name; // 유저명
		HashSet<String> reportList; // 피신고자 리스트
		HashSet<String> reportedList; // 신고자 리스트

		public User(String name) {
			this.name = name;
			reportList = new HashSet<>();
			reportedList = new HashSet<>();
		}
	}

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		ArrayList<User> users = new ArrayList<>();
		HashMap<String, Integer> suspendedList = new HashMap<>();
		HashMap<String, Integer> idIdx = new HashMap<>();
		int idx = 0;

		// 각 유저에 대한 고유 index를 setting후 users ArrayList에 User 객체 추가
		for (String name : id_list) {
			idIdx.put(name, idx++);
			users.add(new User(name));
		}

		// users의 idIdx.get(str[0])번째 index에 reportList에 피신고자 추가
		// users의 idIdx.get(str[1])번째 index에 reportedList에 신고자 추가
		for (String re : report) {
			String[] str = re.split(" ");
			users.get(idIdx.get(str[0])).reportList.add(str[1]);
			users.get(idIdx.get(str[1])).reportedList.add(str[0]);
		}

		// reportedList의 크기가 주어진 k와 같거나 크면 suspendedList의 피신고자 put
		for (User user : users) {
			if (user.reportedList.size() >= k)
				suspendedList.put(user.name, 1);
		}

		// answer 배열 각 index에 해당하는 유저의 신고당한 횟수를 count up
		for (User user : users) {
			for (String nameReport : user.reportList) {
				if (suspendedList.get(nameReport) != null) {
					answer[idIdx.get(user.name)]++;
				}
			}
		}

		return answer;
	}

}
