package ch06정렬;

import java.util.Arrays;

public class QuickSort {

	static void quickSort(int[] arr, int start, int end) {
		if (start >= end) { // 원소가 1개 이면 early return
			return;
		}

		int pivot = start; // 첫 번째 원소를 피봇으로 설정
		int left = start + 1; // 피봇 다음 데이터가 왼쪽 구간의 시작
		int right = end; // 마지막 데이터가 오른쪽 구간의 시작

		while (left <= right) {
			while (left <= end && arr[left] <= arr[pivot]) { // 피봇보다 큰 데이터를 찾기
				left++; // 왼쪽 구간 탐색 -> 피봇보다 큰 데이터 찾기
			}

			while (right > start && arr[right] >= arr[pivot]) { // 피봇보다 작은 데이터를 찾기
				right--; // 오른쪽 구간 탐색 -> 피봇보다 작은 데이터 찾기
			}

			if (left > right) { // 구간이 엇갈렸다면 작은 데이터와 피봇을 교체
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			} else { // 구간이 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		// 피봇을 기준으로 분할 이후 왼쪽 공간과 오른쪽 공간 정렬
		quickSort(arr, start, right - 1);
		quickSort(arr, right + 1, end);

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
		}

		System.out.println("처음 상태: " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
	}

}
