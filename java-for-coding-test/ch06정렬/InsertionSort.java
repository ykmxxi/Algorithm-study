package ch06정렬;

import java.util.Arrays;

public class InsertionSort {

	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) { // 2번째 데이터 부터 시작

			int temp = arr[i]; // 현재 위치의 값을 저장
			int prev = i - 1; // 현재 위치의 이전 인덱스

			while ( (prev >= 0) && (temp < arr[prev])) { // 이전 인덱스가 0 이상이고, 현재 위치의 값이 이전 인덱스보다 작으면
				arr[prev + 1] = arr[prev]; // 이전 인덱스의 값을 오른쪽으로 한칸 이동
				prev--; // 더 이전 위치로 이동
			}

			arr[prev + 1] = temp; // prev 에 위치한 값보다 크므로 prev + 1번 자리에 값을 삽입
		}

		System.out.println("정렬 완료: " + Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
		}

		System.out.println("처음 상태: " + Arrays.toString(arr));
		insertionSort(arr);
	}

}
