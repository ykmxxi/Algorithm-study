# 18258번: 큐 2
- [백준 자료 구조(Data structure) 18258번: 큐 2](https://www.acmicpc.net/problem/18258)

## 풀이
- LinkedList 이용
``` Java
LinkedList<Integer> q = new LinkedList<>();
q.offer();	// push
q.pop();	// pop
q.size();	// size
q.isEmpty();	// empty
q.peek();	// front
q.peekLast();	// back
```
## 문제
- 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리
  - push X: 정수 X를 큐에 넣는 연산이다.
  - pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  - size: 큐에 들어있는 정수의 개수를 출력한다.
  - empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
  - front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  - back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

## 입력
- 첫째 줄: 명령의 수 N
  - 1 <= N <= 2,000,000
- 둘째 줄 부터 N개의 줄에는 명령이 하나씩 주어진다.
  - 주어지는 정수는 1 이상 100,000 이하 (int)

## 출력
- 출력해야하는 명령이 주어질 때마다 한 줄에 하나씩 출력

## 예제
- 입력
```text
15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front
```
- 출력
```text
1
2
2
0
1
2
-1
0
1
-1
0
3
```