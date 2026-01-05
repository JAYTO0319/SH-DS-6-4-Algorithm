from collections import deque
import sys
input = sys.stdin.readline

def bfs(x, y, visietd):
    queue = deque([(x, y)])
    move = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    
    while queue:
        cx, cy = queue.pop()
        for dx, dy in move:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and farm[nx][ny] == 1:
                visited[nx][ny] = True
                queue.append((nx, ny))

t = int(input())
for _ in range(t):
    m, n, k = map(int, input().split())

    # 1. 배추 위치 입력받기
    farm = [[0] * n for _ in range(m)]
    loc = []
    for _ in range(k):
        x, y = map(int, input().split())
        farm[x][y] = 1
        loc.append((x, y))

    # 2. 필요한 최소 지렁이 수 구하기
    visited = [[False] * n for _ in range(m)]
    count = 0
    for x, y in loc:
        if not visited[x][y]:
            visited[x][y] = True
            bfs(x, y, visited)
            count += 1

    # 3. 최소 지렁이 수 출력
    print(count)
