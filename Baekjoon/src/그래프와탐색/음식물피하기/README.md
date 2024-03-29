# 1743번: 음식물 피하기
- [백준 그래프 탐색 알고리즘 1743번: 음식물 피하기](https://www.acmicpc.net/problem/1743)

## 풀이
- 정답의 최대치: 100 x 100 모두 음식물이 있을 때, 10^4 (int)
- DFS 로 인접한 쓰레기간 경로의 길이(size) 구하기

## 문제
- 음식물이 통로 중간 중간에 떨어져 있다. 이런 음식물들은 근처에 있는 것끼리 뭉쳐 큰 음식물 쓰레기가 된다
  - 상, 하, 좌, 우 인접한 음식물은 뭉쳐서 큰 쓰레기가 된다
- 떨어진 음식물 중 제일 큰 음식물만은 피해 가려고 한다
- 제일 큰 음식물의 크기를 구해서 `10ra`를 외치지 않도록 하는 문제

## 입력
- 첫째 줄: N (통로의 세로 길이, 행) M(통로의 가로 길이, 열) K(음식물 쓰레기의 개수)
  - 1 <= N, M <= 100
  - 1 <= K <= N * M
- 둘째 줄부터 K개의 줄에 걸쳐 음식물이 떨어진 좌표가 주어진다
  - (r, c) (r = 행, c = 열)
  - A[r][c] = 1
  - 좌표는 중복되지 않는다

## 출력
- 첫째 줄: 음식물 중 가장 큰 음식물의 크기

## 예제
- 입력
```text
3 4 5
3 2
2 2
3 1
2 3
1 1
```
- 출력
```text
4
```
