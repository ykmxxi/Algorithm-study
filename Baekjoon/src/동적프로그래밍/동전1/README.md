# 2293번: 동전 1
- [백준 동적 프로그래밍(Dynamic Programming) 2293번: 동전 1](https://www.acmicpc.net/problem/2293)

## 풀이
- 모든 경우를 탐색하는 것은 불가능
- 가짜문제 정의
  - 진짜문제: n개의 동전을 적당히 사용해 k원을 만들 수 있는 경우의 수
  - 가짜문제: Dy[i] -> n개의 동전을 적당히 사용해 i원을 만들 수 있는 경우의 수 
- 진짜문제를 풀 수 있나? Dy[K] 가 진짜 문제의 정답
- 초기값
  - 점화식을 풀기 위해 0원을 만들 수 있는 경우의 수를 선택 
- 점화식
  - k >= A[i] 보다 클 때, Dy[k] = Dy[k] + Dy[k - A[i]]

## 문제
- n 가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다
- 이 동전을 적당히 사용해 그 가치의 합이 k원이 되도록 하고 싶다
- 그 경우의 수를 구하는 문제
  - 각각의 동전은 몇 개라도 사용할 수 있다
  - 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우
  - (1, 1, 2), (1, 2, 1), (2, 1, 1) 은 같은 경우 -> 조합

## 입력
- 첫째 줄: n k
  - 1 <= n <= 100
  - 1 <= k <= 10,000
- 둘째 줄 부터 n개의 줄에 걸쳐 각각의 동전의 가치가 주어진다
  - 동전의 가치는 100,000 이하 자연수

## 출력
- 첫째 줄: 경우의 수
  - 경우의 수는 2^31 미만 (int)

## 예제
- 입력
```text
3 10
1
2
5
```
- 출력
```text
10
```