import sys
from collections import deque

# 빠른 입력
input = sys.stdin.readline

# 1. 전체 사람 수
n = int(input().strip())

# 2. 촌수 계산할 두 사람
a, b = map(int, input().split())

# 3. 관계 개수
m = int(input().strip())

# 그래프 인접 리스트
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    x, y = map(int, input().split())
    # 부모/자식 관계는 양방향
    graph[x].append(y)
    graph[y].append(x)

# 방문 체크 및 촌수 계산 배열
visited = [0] * (n + 1)

# BFS 큐
queue = deque()
queue.append(a)
visited[a] = 1  # 시작 노드 촌수 base = 1

result = -1

while queue:
    current = queue.popleft()

    # 목표에 도달하면 촌수 계산 (실제 촌수 = visited - 1)
    if current == b:
        result = visited[current] - 1
        break

    # 연결된 사람들 탐색
    for nxt in graph[current]:
        if visited[nxt] == 0:
            visited[nxt] = visited[current] + 1
            queue.append(nxt)

# 연결되지 않았으면 -1, 아니면 계산된 촌수 출력
print(result)
