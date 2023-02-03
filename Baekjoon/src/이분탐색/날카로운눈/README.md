# 1637번: 날카로운 눈
- [백준 이분 탐색(binary search), 매개변수 탐색 1637번: 날카로운 눈](https://www.acmicpc.net/problem/1637)

## 풀이
- 원래 문제: 정수더미에서 홀수개 존재하는 특정한 하나의 정수는?
- 뒤집은 문제: 어떤 정수가 존재할 때, 그 정수 까지의 개수 누적합이 홀수개? Yes or No
  - 개수가 홀수인 정수는 한개만 존재하므로
  - Yes: 홀수 + 짝수 + 짝수 ... + 짝수 = 홀수
  - No: 짝수 + 짝수 + 짝수 ... + 짝수 = 짝수
- L: 1
- R: Integer.MAX_VALUE(2,147,483,647)
``` java
static int count(int A, int C, int B, int candidate) { // 어떤 수 candidate 까지의 개수 누적합 계산
		// A, A + B, A + 2B, ..., A + kB (A + kB <= C)
		if (candidate < A) {
			return 0;
		}
		if (C < candidate) {
			// A, A + B, ..., A + kB -> k + 1개 -> A + kB <= C, k + 1 <= (C-A) / B + 1
			return (C - A) / B + 1;
		}
		// A, A + B, ..., A + xB(candidate), ..., A + kB -> x + 1 <= (candidate - A) / B + 1
		return (candidate - A) / B + 1;
	}
```

## 문제
- 정수가 여러 개 모여 있는 정수더미(수열)
- 그 안에 어떤 특정한 정수 하나만 홀수개 존재하고 나머지 정수는 모두 짝수개
- 홀수개 존재하는 정수를 찾는 문제

## 입력
- 첫째 줄: N(입력의 개수)
  - 1 <= N <= 20,000
- 둘째 줄 부터 N줄에 걸쳐 세 개의 정수 A, C, B가 주어진다
  - A, A + B, A + 2B, ..., A + kB (A + kB <= C)
  - A, B, C는 1 이상 2,147,483,647(Integer.MAX_VALUE) 이하의 정수

## 출력
- 첫째 줄에 정수 두개를 출력
  - 첫 번째 정수: 홀수개 존재하는 정수를 출력
  - 두 번째 정수: 그 정수가 몇 개 들어있는지 출력
  - 만약 홀수개 존재하는 정수가 없다면 `NOTHING` 출력

## 예제
- 입력
``` text
4
1 10 1
4 4 1
1 5 1
6 10 1
```
- 출력
``` text
4 3
```