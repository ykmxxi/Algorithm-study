# 15565번: 귀여운 라이언
- [백준 두 포인터(Two Pointers) 알고리즘 15565번: 귀여운 라이언](https://www.acmicpc.net/problem/15565)

## 풀이
- L: 조건을 만족하는 왼쪽 구간의 끝
- R: 조건을 만족하는 오른쪽 구간의 끝
- cnt: 구간 [L, R]의 1(라이언 인형)의 갯수

## 문제
- 라이언 인형과 어피치 인형이 N개 일렬로 놓여 있다.
  - 라이언 인형은 1, 어피치 인형은 2로 표현
- 라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기
  - 순서를 지키며 차례대로 K개 이상 있는 연속된 부분 수열의 크기 중 최소값 -> 두 포인터 키워드

## 입력
- 첫째 줄: N(총 인형의 개수) K(기준 값)
  - 1 <= K <= N <= 10^6 (int)
- 둘째 줄: N개의 인형의 정보 (1 or 2)

## 출력
- 첫째 줄: K개 이상의 라이언 인형(1)을 포함하는 가장 작은 연속된 인형들의 집합의 크기
  - 그런 집합이 없다면 -1을 출

## 예제
- 입력
```text
10 3
1 2 2 2 1 2 1 2 2 1
```
- 출력
```text
6
```