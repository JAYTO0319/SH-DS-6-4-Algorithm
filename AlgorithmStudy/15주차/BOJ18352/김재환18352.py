import sys
from collections import deque

input = sys.stdin.readline
N, M, K, X = map(int, input().split())

# 인접 리스트
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)

# 거리 배열 (-1은 미방문 뜻함)
dist = [-1] * (N+1)
dist[X] = 0

q = deque([X])
while q:
    now = q.popleft()
    for nei in graph[now]:
        if dist[nei] == -1:   # 아직 방문 안 했으면
            dist[nei] = dist[now] + 1
            q.append(nei)

# 최단거리 K인 도시들 수집
ans = [i for i in range(1, N+1) if dist[i] == K]

if ans:
    ans.sort()
    print(*ans, sep="\n")
else:
    print(-1)
