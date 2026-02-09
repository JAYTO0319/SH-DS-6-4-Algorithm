from collections import deque

n, k = map(int, input().split())
num = deque([i for i in range(1, n + 1)])
print('<', end='')
while num:
    num.rotate(-k + 1)
    x = num.popleft()
    if num:
        print(x, end=', ')
    else:
        print(x, end='')
print('>')
