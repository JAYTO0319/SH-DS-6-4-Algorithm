from collections import deque
import sys
input = sys.stdin.readline

def dfs(start):
    stack = [start]
    result = []

    while stack:
        v = stack.pop()

        if visited[v]:
            continue

        visited[v] = True
        result.append(v)

        # 작은 번호부터 방문하려면 역순으로 push
        for nxt in reversed(graph[v]):
            if not visited[nxt]:
                stack.append(nxt)

    print(*result)

def bfs(start):
    q = deque([start])
    visited[start] = True
    result = []

    while q:
        v = q.popleft()
        result.append(v)

        for nxt in graph[v]:
            if not visited[nxt]:
                visited[nxt] = True
                q.append(nxt)

    print(*result)

# 입력
n, m, v = map(int, input().split())

graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    graph[i].sort()

# DFS
dfs(v)

# visited 초기화
visited = [False] * (n + 1)

# BFS
bfs(v)
