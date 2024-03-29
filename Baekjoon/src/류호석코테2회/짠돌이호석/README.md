# 21277번: 짠돌이 호석
- [백준 구현, 완전 탐색(Brute Force) 21277번: 짠돌이 호석](https://www.acmicpc.net/problem/21277)

## 풀이
- 2차원 배열의 평행 이동, 배열 돌리기
- 두 배열을 모두 회전 시킬 필요가 없음
  - 한 배열을 고정 시키고, 두 번째 배열만 4방향 회전
  - ``` java
    for (두 번째 퍼즐 회전 4번)
      for (모든 x 축 평행 이동)
        for (모든 y 축 평행 이동)
          첫 번째 퍼즐과 회전한 퍼즐이 겹치지 않으면 정답 갱신
    ```
- 총 시간 복잡도
  - 4 번의 회전 * 가로 방향으로 약 100 번의 이동 가능성 * 세로 방향으로 약 100 번의 이동 가능성 * 배열 전체에 대해 겹치는 부분 확인
  - 4 * 100 * 100 * O(NM) = 4 * 10^4 * 2500 = 10^8

## 문제
- 두 개의 퍼즐은 각자 N1 행 M1 열, N2행 M2열의 격자 형태로 이루어져 있다.
- 각 격자는 정사각형 모양이며, 퍼즐 조각이 있을 수도 있고, 없을 수도 있다
- 퍼즐이 2개가 완성되어 보관해야 하는 액자를 구매해야 한다.
  - 액자의 가격은 액자의 넓이 (행의 개수 * 열의 개수)
- 퍼즐 두 개를 퍼즐 조각끼리 같은 격자에서 만나지 않도록 배치해서 하나의 액자에 담는 방법 중 가장 적은 비용일 때를 찾는 문제
  - 각 퍼즐은 90도, 180도, 270도로 자유롭게 회전시켜도 된다

## 입력
- 첫째 줄: N1 M1
  - 1 <= N1, M1 <= 50
- 둘째 줄 부터 N1개의 줄에 걸쳐 M1 개의 정보가 주어진다
  - 정보는 0 or 1, 0: 퍼즐 조각이 없는 격자, 1: 퍼즐 조각이 있는 격자
- 다음 줄: N2 M2
  - 1 <= N2, M2 <= 50
- N2개의 줄에 걸쳐 M2개의 정보가 주어진다
  - 정보는 0 or 1, 0: 퍼즐 조각이 없는 격자, 1: 퍼즐 조각이 있는 격자
- 두 퍼즐 모두 4개 모서리에 최소 하나의 1은 존재하는 것이 보장된다

## 출력
- 첫째 줄: 두 개의 퍼즐을 담을 수 있는 액자들 중 최소 넓이

## 예제
- 입력
```text
5 5
11111
10000
11111
10000
11111
5 3
101
101
101
101
111
```
- 출력
```text
30

// 2번 블록을 반시계 방향으로 90도 회전 후 합치면 아래와 같다 (1: 첫 번째 퍼즐의 조각, 2: 두 번째 퍼즐의 조각)
111110
122222
111112
122222
111110
-> 6 * 5 = 30
```