from collections import deque
import sys
input = sys.stdin.readline

# 적록색약 X
def bfs(queue, visited, c):
    move = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    while queue:
        x, y = queue.popleft()
        for dx, dy in move:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and color[nx][ny] == c:
                visited[nx][ny] = True
                queue.append((nx, ny))

# 적록색약 O
def bfs_blind(queue, visited, c):
    move = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    while queue:
        x, y = queue.popleft()
        for dx, dy in move:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if ((c == 'R' or c == 'G') and (color[nx][ny] == 'R' or color[nx][ny] == 'G')) or (c == 'B' and color[nx][ny] == 'B'):
                    visited[nx][ny] = True
                    queue.append((nx, ny))

# 입력받기
n = int(input())
color = []
for _ in range(n):
    color.append(list(input().rstrip()))

# 적록색약 X
queue = deque([])
visited = [[False] * n for _ in range(n)]
count = 0

# 적록색약 O
queue_blind = deque([])
visited_blind = [[False] * n for _ in range(n)]
count_blind = 0

for i in range(n):
    for j in range(n):
        # 적록색약 X
        if not visited[i][j]:
            visited[i][j] = True
            queue.append((i, j))
            bfs(queue, visited, color[i][j])
            count += 1

        # 적록색약 O
        if not visited_blind[i][j]:
            visited_blind[i][j] = True
            queue_blind.append((i, j))
            bfs_blind(queue_blind, visited_blind, color[i][j])
            count_blind += 1

# 출력하기
print(count, end = ' ')
print(count_blind)
