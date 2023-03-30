package ch07이진탐색;

import java.util.Scanner;

public class BinarySearchByLoop {

	static int binarySearch(int[] arr, int target, int L, int R) {
		while (L <= R) {
			int mid = (L + R) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] <= target) { // 기준값이 찾으려는 데이터 보다 작으니 L을 mid + 1로 땡겨온다
				L = mid + 1;
			} else { // 기준값이 찾으려는 데이터 보다 크니 R을 mid - 1로 땡겨온다
				R = mid - 1;
			}
		}

		return -1; // 존재하지 않음
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
		int n = sc.nextInt();
		int target = sc.nextInt();

		// 전체 원소 입력받기
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 이진 탐색 수행 결과 출력
		int result = binarySearch(arr, target, 0, n - 1);
		if (result == -1) {
			System.out.println("원소가 존재하지 않습니다.");
		} else {
			System.out.println((result + 1) + "번 째 원소가 찾으려는 값입니다.");
		}
	}

}
