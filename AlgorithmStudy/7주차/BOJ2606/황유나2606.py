import sys
input = sys.stdin.readline

def dfs(graph, v, visited):
    global count
    for c in graph[v]:
        if not visited[c]:
            visited[c] = True
            count += 1
            dfs(graph, c, visited)

n = int(input()) # 컴퓨터의 수
m = int(input()) # 간선의 수

count = 0 # 바이러스에 걸린 컴퓨터 개수
visited = [False] * (n + 1)
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

# 1번 컴퓨터에서 바이러스 전파
visited[1] = True
dfs(graph, 1, visited)

print(count)
