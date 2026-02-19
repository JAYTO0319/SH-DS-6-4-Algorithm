import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

N, D = map(int, input().split())

# 그래프: 각 위치에서 갈 수 있는 (다음위치, 거리) 목록
graph = [[] for _ in range(D+1)]

# 1씩 증가하는 일반 도로
for i in range(D):
    graph[i].append((i+1, 1))

# 지름길 추가
for _ in range(N):
    s, e, dist = map(int, input().split())
    # 지름길 이용 시 효율이 있고 D 범위 안이라면 추가
    if e <= D and dist < (e - s):
        graph[s].append((e, dist))

# 최단 거리 배열 초기화
distance = [INF] * (D+1)

# 다익스트라
def dijkstra(start):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        cur_dist, node = heapq.heappop(q)

        if cur_dist > distance[node]:
            continue

        for nxt, cost in graph[node]:
            new_dist = cur_dist + cost
            if new_dist < distance[nxt]:
                distance[nxt] = new_dist
                heapq.heappush(q, (new_dist, nxt))

dijkstra(0)

print(distance[D])
