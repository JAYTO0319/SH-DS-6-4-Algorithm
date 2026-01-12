import sys
input = sys.stdin.readline

# 초기 문자열
initial = input().rstrip()

# 왼쪽/오른쪽 스택
left = list(initial)  # 커서 왼쪽
right = []            # 커서 오른쪽

# 명령 수
M = int(input().rstrip())

for _ in range(M):
    cmd = input().split()

    # 커서 왼쪽
    if cmd[0] == 'L':
        if left:  # 왼쪽이 비어 있지 않으면
            right.append(left.pop())

    # 커서 오른쪽
    elif cmd[0] == 'D':
        if right:  # 오른쪽이 비어 있지 않으면
            left.append(right.pop())

    # 왼쪽 문자 삭제
    elif cmd[0] == 'B':
        if left:
            left.pop()

    # 삽입
    elif cmd[0] == 'P':
        # cmd[1]에 넣을 문자
        left.append(cmd[1])

# 출력: left + reversed(right)
# reversed(right)는 스택이니까 뒤집어야 원래 순서
print(''.join(left + right[::-1]))
