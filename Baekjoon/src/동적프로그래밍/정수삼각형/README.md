# 1932번: 정수 삼각형
- [백준 동적 프로그래밍(Dynamic Programming) 1932번: 정수 삼각형](https://www.acmicpc.net/problem/1932)

## 풀이
- 가짜문제 정의
  - 진짜문제: N까지 경로 중 선택된 수의 합의 최대값
  - 가짜문제: Dy[i][i] -> 시작점이 (1, 1)일 때, (i, j) 까지 도착하는 경로 중 선택된 수의 합의 최대값
- Dy[N][1], Dy[N][2], ..., Dy[N][N] 중 가장 큰 값이 진짜문제의 정답
- 초기값: Dy[1][1] = A[1][1]
- 점화식
  - Dy[i][1] = Dy[i - 1][1] + A[i][1]
  - Dy[i][j] = Math.max(Dy[i - 1][j - 1], Dy[i - 1][j]) + A[i][j]
    - 2 <= j < i
  - Dy[i][i] = Dy[i - 1][i - 1] + A[i][i]

## 문제
- 맨 위층 부터 시작해서 아래에 있는 수 중 하나를 선택해 아래층으로 내려올 때, 선택된 수의 합이 최대가 되는 경로를 구하기
  - 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 or 대각선 오른쪽에 있는 것 중 하나만 선택
  - 삼각형의 크기는 1 이상 500 이하
  - 각 수는 모두 0 이상 9,999 이하 정수

## 입력
- 첫째 줄: N(삼각형의 크기)
  - 1 <= N <= 500
- 둘째 줄 부터 N개의 줄에 걸쳐 정수 삼각형이 주어진다
  - 0 이상 9,999 이하

## 출력
- 첫째 줄: 합이 최대가 되는 경로에 있는 수의 합을 출력

## 예제
- 입력
```text
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
```
- 출력
```text
30
```