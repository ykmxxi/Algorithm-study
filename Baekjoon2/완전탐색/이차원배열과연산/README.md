# 17140번: 이차원 배열과 연산
- [백준 17140번: 이차원 배열과 연산](https://www.acmicpc.net/problem/17140)

## 문제
- 3 x 3 배열 A, 인덱스는 1부터 시작하고 1초가 지날때마다 배열에 연산이 적용됨
  - R 연산: 배열 A의 모든 행에 대해서 정렬을 수행, 행의 개수 >= 열의 개수인 경우에 적용
  - C 연산: 배열 A의 모든 열에 대해서 정렬을 수행, 행의 개수 < 열의 개수인 경우에 적용
- 한 행 또는 열에 있는 수를 정렬하려면 각각의 수가 몇 번 나왔는지 알아야 함
- 그 다음 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬
- 그 다음 배열 A에 정렬된 결과를 다시 넣어야 함
  - 정렬 우선순위: 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저
  - R 연산이 적용되면 가장 큰 행을 기준으로 모든 행의 크기가 변하고, C 연산이 적용되면 가장 큰 열을 기준으로 모든 열의 크기가 변함
  - 크기가 커진 곳은 0이 채워지고, 수를 정렬할 때 0은 무시한다. [3, 2, 0, 0] -> [3, 2]
  - 행 또는 열의 크기가 100을 넘어가는 경우 처음 100개를 제외한 나머지는 버림
- 배열 A에 들어있는 수와 r, c, k 가 주어졌을 때, A[r][c]에 들어있는 값이 k가 되기 위한 최소 시간

## 입력
- 첫째 줄: r c k
  - 1 <= r, c, k <= 100
- 둘째 줄부터 3개의 줄에 배열 A에 들어있는 수가 주어짐
  - 100 이하의 자연수

## 출력
- 첫째 줄: A[r][c] == k를 만족하는 연산의 최소 시간
  - 100초가 넘어가면 -1을 출력
