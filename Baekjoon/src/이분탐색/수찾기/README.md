# 1920번: 수 찾기
- [백준 이분 탐색(binary search) 1920번: 수 찾기](https://www.acmicpc.net/problem/1920)

## 복잡도
- 시간 복잡도: O (M * log N)

## 문제
- N개의 정수 A[1], A[2], ..., A[N] 이 주어질 때, X라는 정수가 존재하는지 알아내는 문제

## 입력
- 첫째 줄: N(수의 개수)
  - 1 <= N <= 100,000 자연수
- 둘째 줄: N개의 정수가 공백으로 구분되어 입력
  - -2^31 이상 2^31 미만: 약 -20억 ~ 20억 (int)
- 셋째 줄: M(수의 개수)
  - 1 <= M <= 100,000
- 넷째 줄: M개의 정수가 공백으로 구분되어 입력
  - -2^31 이상 2^31 미만: 약 -20억 ~ 20억 (int)

## 출력
- M개의 줄에 답을 출력
  - 존재하면 1
  - 존재하지 않으면 0

## 예제
- 입력
```text
5
4 1 5 2 3
5
1 3 7 9 5
```
- 출력
```text
1
1
0
0
1
```