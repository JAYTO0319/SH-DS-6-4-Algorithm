import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

# 상하좌우
dr = (-1, 1, 0, 0)
dc = (0, 0, -1, 1)

# 익은 토마토 시작점 다중 BFS
queue = deque()

for r in range(N):
    for c in range(M):
        if board[r][c] == 1:
            # day 0부터 시작
            queue.append((r, c))

# BFS
while queue:
    r, c = queue.popleft()
    for k in range(4):
        nr, nc = r + dr[k], c + dc[k]
        if 0 <= nr < N and 0 <= nc < M and board[nr][nc] == 0:
            # 익히고 날짜 저장
            board[nr][nc] = board[r][c] + 1
            queue.append((nr, nc))

# 결과 계산
ans = 0
for r in range(N):
    for c in range(M):
        if board[r][c] == 0:
            # 안 익은 토마토 남아있음
            print(-1)
            sys.exit(0)
        ans = max(ans, board[r][c])

# BFS가 익은 토마토 수치로 day 저장했으므로
# 익은 건 1부터 시작 → (최대) – 1 이 실제 경과일수
print(ans - 1)
