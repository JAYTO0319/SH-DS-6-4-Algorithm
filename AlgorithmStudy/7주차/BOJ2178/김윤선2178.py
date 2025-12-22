from collections import deque

n, m = map(int, input().split())

arr = []
for _ in range(n):
    arr.append(list(map(int, input().strip())))

def bfs():
    dist = [[0]*m for _ in range(n)]
    dy = (-1, 1, 0, 0)
    dx = (0, 0, -1, 1)

    q = deque()
    q.append((0, 0))
    dist[0][0] = 1   # 시작 거리

    while q:
        y, x = q.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            #맵 범위
            if not (0 <= ny < n and 0 <= nx < m):
                continue
            #벽
            if arr[ny][nx] == 0:
                continue
            
            #방문 안 한 칸
            if dist[ny][nx] == 0:
                dist[ny][nx] = dist[y][x] + 1
                q.append((ny, nx))

    return dist[n-1][m-1]

print(bfs())
