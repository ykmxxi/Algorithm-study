# 2470번: 두 용액
- [백준 두 포인터(Two Pointers) 알고리즘 2470번: 두 용액](https://www.acmicpc.net/problem/2470)
- [2470번 두 용액: 이분 탐색(binary search) 알고리즘을 이용한 풀이](https://github.com/ykmxxi/Algorithm-study/tree/main/Baekjoon/src/%EC%9D%B4%EB%B6%84%ED%83%90%EC%83%89/%EB%91%90%EC%9A%A9%EC%95%A1)

## 풀이
- 이분 탐색 방법
  - 이분 탐색: 정렬 (N log N) + 이분 탐색 (N log N) = 총 시간 복잡도 O(N log N)
- 두 포인터
  - L: 남아 있는 것들 중 제일 작은 원소
  - R: 남아 있는 것들 중 제일 큰 원
  - 최소 + 최대 < 0 인 경우
    - 최소 입장에서는 최선책을 만난 상태, 짝을 찾았으니 최소값 삭제(더 고려할 가치가 없음)
      - 가장 큰 값과 합쳤을 때 음수이니, 더 고려할 필요가 없음
  - 최소 + 최대 > 0 인 경우
    - 최대 입장에서는 최선책을 만난 상태, 짝을 찾았으니 최대값 삭제(더 고려할 가치가 없음)
      - 가장 작은 값과 합쳤을 때 양수이니, 더 고려할 필요가 없음
1. 탐색할 배열 정렬 -> O(N log N)
   - 최소: A[1], 최대: A[N] 두 포인터 L(최소), R(최대) 초기 설정
2. 매 순간 L, R로 계산한 후 이동 -> O(N)
3. 총 O(N log N)의 시간이 걸림

## 문제
- 산성 용액과, 알칼리성 용액이 존재. 각 용액은 그 용액의 특성을 나타내는 하나의 정수가 주어짐
  - 산성 용액의 특성값: 1 ~ 1,000,000,000 (int)
  - 알칼리성 용액의 특성값: -1 ~ -1,000,000,000 (int)
- 두 용액을 혼합(각 용액의 특성값의 합), 혼합한 특성값이 0에 가장 가까운 용액을 만드는 문제
  - 혼합 값: -20억 ~ 20억, (int)
  - [-2, 4, -99, -1, 98]인 경우: [-99, 98]
  - 꼭 알칼리성 + 산성 용액을 섞을 필요는 없음. 같은 특성의 용액끼리 혼합해 0에 가까우면 선택 가능
    - [-1, -2, 99, 100]인 경우: [-1, -2]

## 입력
- 첫째 줄: N(전체 용액의 수)
  - 2 이상 100,000이하 (int[ ])
- 둘째 줄: 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사이에 두고 주어짐
  - 각 특성값은 -1,000,000,000 이상 1,000,000,000 이하
  - 각 특성값은 모두 다름(중복 허용X)

## 출력
- 첫째 줄: 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값 출력
  - 두 용액은 공백으로 구분해 특성값의 오름차순으로 출력
  - 특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우 그 중 아무것이나 하나 출력

## 예제
- 입력
```text
5
-2 4 -99 -1 98
```
- 출력
```text
-99 98
```