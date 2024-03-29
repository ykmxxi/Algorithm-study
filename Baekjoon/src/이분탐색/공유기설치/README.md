# 2110번: 공유기 설치
- [백준 이진 탐색(binary search), 매개변수 탐색 2110번: 공유기 설치](https://www.acmicpc.net/problem/2110)

## 풀이
- 원래 문제: C개의 공유기를 N개의 집에 설치해 가장 인접한 두 공유기 사이의 거리의 최대값
  - C개의 공유기를 설치했을 때, 최대 인접 거리는 얼마?
- 뒤집은 문제: 가장 인접한 두 공유기 사이의 거리를 설정했을 때, 나머지 공유기 사이의 거리가 가장 인접한 두 공유기 사이의 거리보다 길어? Yes or No
  - 어떤 인접 거리만큼을 거리를 둘 때, 공유기 C개를 설치할 수 있나? Yes or No
1. 주어진 집들을 정렬 -> O(N log N)
2. distance를 정해서 결정 문제 한 번 풀기 -> O(N)
3. 정답의 범위를 이분 탐색하면서 풀기 -> O(log X)번 반복
4. 총 시간 복잡도: O(N logN + N log X)
   - O(뒤집은 문제 * log 10억)은 약 N * 30, 최악의 경우(N = 20만) 6백만

## 문제
- 집 N개가 수직선 위에 존재
  - 각각의 집 좌표는 X1, X2, ..., XN
  - 집의 좌표가 중복되는 경우는 없음
- 공유기 C개를 설치할 때 최대한 많은 곳에서 와이파이 사용
  - 한 집에는 한 개의 공유기만 설치 가능
  - 인접한 두 공유기 사이의 거리를 가능한 크게 하여(최대값) 설치
- C개의 공유기를 N개의 집에 적당히 설치해, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 문제 
  - 매개변수 탐색 키워드

## 입력
- 첫째 줄: N(집의 개수) C(공유기 개수)
  - 2 <= N <= 200,000 (int)
  - 2 <= C <= N (int)
- 둘째 줄 ~ N + 1째 줄: 집의 좌표
  - 0 <= 집의 좌표 <= 1,000,000,000 (int)

## 출력
- 첫째 줄: 가장 인접한 두 공유기 사이의 최대 거리
  - 최악의 경우: N = 2, C = 2일 때: 10억 (int)

## 예제
- 입력
```text
5 3
1
2
8
4
9
```
- 출력
```text
3
```