import sys
input = sys.stdin.readline

left = list(input().rstrip())
right = []
m = int(input())
for _ in range(m):
    cmd = input()
    c = cmd[0] # 명령어
    
    if c == 'L':
        if len(left) > 0: # 기존 커서의 위치가 왼쪽 끝이 아닐 때
            right.append(left.pop())
    elif c == 'D':
        if len(right) > 0: # 기존 커서의 위치가 오른쪽 끝이 아닐 때
            left.append(right.pop())
    elif c == 'B':
        if len(left) > 0: # 기존 커서의 위치가 왼쪽 끝이 아닐 때
            left.pop()
    else:
        x = cmd[2] # 추가할 문자
        left.append(x)

for s in left + right[::-1]:
    print(s, end='')
