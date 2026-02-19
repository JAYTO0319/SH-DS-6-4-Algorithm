import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())
dq = deque(range(1, N+1))
result = []

while dq:
    dq.rotate(-(K-1))  # 앞쪽으로 K-1 만큼 회전
    result.append(dq.popleft())

print("<" + ", ".join(map(str, result)) + ">")
