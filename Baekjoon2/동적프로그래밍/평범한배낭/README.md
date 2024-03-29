# 12865번: 평범한 배낭
- [백준 동적 프로그래밍(Dynamic Programming) 12865번: 평범한 배낭](https://www.acmicpc.net/problem/12865)

## 풀이
- 초기값: 무게가 1 ~ K 까지 아무것도 넣지 않았을 때의 가치는 0
  - Dy[0][1] ~ Dy[0][K] = 0
- 점화식: Dy[i][j] = Math.max(Dy[i][j], Dy[i - 1][j - A[i][0]] + A[i][1])

## 문제
- 배낭을 최대한 가치 있게 싸려는 문제
- N개의 물건은 각각 무게 W, 가치 V를 가진다
- 최대 K만큼의 무게를 넣을 수 있는 배낭을 들고 다닐 때, 배낭에 넣을 수 있는 물건들의 가치의 최대값을 구하는 문제

## 입력
- 첫째 줄: N K
  - 1 <= N <= 100
  - 1 <= K <= 100,000
- 둘째 줄부터 N개의 줄에 걸쳐 W V 가 주어진다
  - 1 <= W <- 100,000
  - 0 <= V <= 1,000

## 출력
- 배낭에 넣을 수 있는 물건들의 가치합의 최대값

## 예제
- 입력
```text
4 7
6 13
4 8
3 6
5 12
```
- 출력
```text
14
```