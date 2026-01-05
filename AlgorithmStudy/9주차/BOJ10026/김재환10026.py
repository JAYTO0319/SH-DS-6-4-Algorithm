from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
graph = [list(input().strip()) for _ in range(n)]

# 상, 하, 좌, 우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, color_blind):
    """
    x, y : 시작 좌표
    color_blind : True면 적록색약, False면 정상
    """
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    start_color = graph[x][y]

    while queue:
        cx, cy = queue.popleft()

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            # 범위 체크 + 방문 여부
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:

                if color_blind:
                    # 적록색약인 경우
                    # R과 G는 같은 색으로 본다
                    if (start_color in "RG" and graph[nx][ny] in "RG") or \
                       (start_color == "B" and graph[nx][ny] == "B"):
                        visited[nx][ny] = True
                        queue.append((nx, ny))
                else:
                    # 정상 시야: 색이 정확히 같아야 함
                    if graph[nx][ny] == start_color:
                        visited[nx][ny] = True
                        queue.append((nx, ny))

# -------- 정상 시야 --------
visited = [[False] * n for _ in range(n)]
normal_count = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j, False)
            normal_count += 1

# -------- 적록색약 --------
visited = [[False] * n for _ in range(n)]
color_blind_count = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j, True)
            color_blind_count += 1

print(normal_count, color_blind_count)
