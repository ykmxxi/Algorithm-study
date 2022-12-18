# 문자열 다루기 기본

[Programmers Lv1 12918번 문자열 다루기 기본](https://school.programmers.co.kr/learn/courses/30/lessons/12918)

## :hammer_and_wrench:구현 기능 목록
- 문자열은 길이가 4 혹은 6이다.
  - "1234" or "123456"
- 문자열은 숫자로만 구성돼있어야 한다.
- 조건에 적합하면 `true`, 아니면 `false`를 리턴한다.

## 제한 사항
- 문자열`s`는 길이가 1 이상, 8 이하인 문자열이다.
- 문자열`s`는 영문 알파벳 대소문자 또는 0 부터 9까지 숫자로 이루어져 있다.

## 입출력 예
- `s = "a234"` -> false
- `s = "1234"` -> true
- `s = "1234오육"` -> false
- `s = "123456"` -> true