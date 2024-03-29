# 2805번: 나무 자르기
- [백준 이진 탐색(binary search), 매개변수 탐색 2805번: 나무 자르기](https://www.acmicpc.net/problem/2805)

## 풀이
- 정답의 범위는 int 이지만, 계산 과정 중의 변수 타입은 long
- 높이의 최대값(매개 변수 탐색 키워드)
  - 원래 문제: 원하는 길이 M(조건) 만큼을 얻을 수 있는 최대 높이 H(타겟)
  - 뒤집은 문제: 어떤 높이 H(원래 타겟, 조건)로 잘랐을 때, 원하는 길이 M(원래 조건, 타겟) 만큼 얻을 수 있는가? Yes or No
    - 시간 복잡도: O(N * log X), X는 나무의 높이(최악은 나무의 높이가 20억)
      - O(백만 * log 20억) 약 3100만
    
## 문제
- 나무 M 미터가 필요
- 목재 절단기에 높이 H를 지정하면 땅으로부터 H미터 위로 올라가 나무를 자른다.
  - H보다 큰 나무는 H 위의 부분이 잘리고, 낮은 나무는 잘리지 않는다.
  - 예시: 나무[20, 15, 10, 17], H = 15 일 때: 자른 뒤의 높이 [15, 15, 10, 15], 자른 나무 7미터
  - H는 양의 정수
- 적어도 M 미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최대값을 구하는 프로그램

## 입력
- 첫째 줄: N(나무의 수), M(가져가려고 하는 나무의 길이)
  - 1 <= N <= 1,000,000 (int)
  - 1 <= M <= 2,000,000,000 (int)
- 둘째 줄: 나무의 높이
  - 나무의 높이의 합은 항상 M보다 크거나 같다.
  - 각 나무의 높이 0 <= 나무 높이 < 1,000,000,000 (int)
  - 최악의 경우: 2,000,000,000의 나무가 필요할 때, [10억, 4억, 9억] 이면 최적값 23억
  - 가져가는 나무들의 합: (long)

## 출력
- 첫째 줄: M 미터의 나무를 집에 가져가기 위해서 설정할 수 있는 H의 최대값

## 예제
- 입력
```text
5 20
4 42 40 26 46
```
- 출력
```text
36
```