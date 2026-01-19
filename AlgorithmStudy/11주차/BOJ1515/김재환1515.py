import sys

# 빠른 입력 함수
input = sys.stdin.readline

# 남아있는 숫자 문자열
s = input().strip()

# 입력 문자열을 비교하기 위한 '포인터'
pointer = 0

# 실제로 우리가 만들어갈 숫자
# 1부터 증가시키며 반복
num = 0

# pointer가 문자열 끝에 도달할 때까지 계속
while pointer < len(s):
    num += 1               # 다음 숫자를 늘림
    cur = str(num)         # 숫자를 문자열로 변환

    # cur의 각 문자와 입력 문자열의 pointer 위치 비교
    # 만약 일치한다면 pointer를 증가해서
    # 다음 입력 문자열 위치로 넘어간다
    for ch in cur:
        if pointer < len(s) and s[pointer] == ch:
            pointer += 1

# pointer가 입력 문자열을 모두 지나갔다는 건
# 지금까지 만든 숫자 num까지 쓰면 입력 문자열을 모두 포함할 수 있다는 의미
print(num)
