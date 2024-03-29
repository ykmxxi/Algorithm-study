# 14503번: 로봇 청소기
- [백준 그래프 탐색 알고리즘 14503번: 로봇 청소기](https://www.acmicpc.net/problem/14503)

## 풀이
- 격자형 배열과 상하좌우 탐색 -> 그래프 탐색 문제
- 시작점 (r, c) 에서 dfs를 진행
  - 주변 4칸을 탐색해 청소할 곳이 있으면 dfs를 진행
  - 주변 4칸 중 청소할 곳이 없으면 뒤로 한칸 후진, 뒤 칸은 현재 방향의 반대 방향으로 한 칸
    - 뒤 칸이 벽이 아니면 다시 dfs를 진행
    - 뒤 칸이 벽이면 종료

## 문제
- 로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하는 문제
- 로봇 청소기가 있는 방은 N x M 크기의 직사각형
  - 격자형 배열
  - 각 칸은 1 x 1 정사각형
  - 각각의 칸은 벽 or 빈 칸
- 청소기는 바라보는 방향이 있어 동서남북 중 하나
- 처음에 빈 칸은 전부 청소되지 않은 상태
- 로봇 청소기의 작동
1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
   - 바라보는 방향을 유지한 채 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아감
   - 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춤
3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
   - 반시계 방향으로 90도 회전 (북 -> 서, 서 -> 남, 남 -> 동, 동 -> 북)
   - 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
   - 1번으로 돌아감

## 입력
- 첫째 줄: N M
  - 3 <= N, M <= 50
- 둘째 줄: 처음 로봇 청소기가 있는 칸의 좌표(r, c)와 바라보는 방향 d
  - d가 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
- 셋째 줄부터 N개의 줄에 방의 상태가 주어짐
  - 0: 청소되지 않은 빈 칸
  - 1: 벽
  - 방의 가장자리는 모두 벽

## 출력
- 첫째 줄: 청소기가 작동을 시작한 후 멈출 때까지 청소하는 칸의 개수

## 예제
- 입력
```text
3 3
1 1 0
1 1 1
1 0 1
1 1 1

11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
```
- 출력
```text
1

57
```
