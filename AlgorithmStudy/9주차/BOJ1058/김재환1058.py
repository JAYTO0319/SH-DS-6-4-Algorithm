import sys
from collections import deque

input = sys.stdin.readline

# 사람 수 N
N = int(input().strip())
# 친구 관계: Y/N
friends = [input().strip() for _ in range(N)]

# 결과: 가장 많이 2-친구가 있는 사람의 개수
max_2friends = 0

# 각 사람 i마다 BFS 탐색하여 거리 <=2인 사람 수 세기
for i in range(N):
    dist = [-1] * N  # dist[j] = i로부터 j까지 거리 (1:직접,2:친구의 친구)
    queue = deque([i])
    dist[i] = 0      # 자기 자신 거리 0

    while queue:
        cur = queue.popleft()
        # 만약 거리가 2 이상이면 더 이상 깊이 확장 X
        if dist[cur] == 2:
            continue

        # 모든 후보 j에 대하여
        for j in range(N):
            # 친구 관계이고 방문 안 했다면
            if friends[cur][j] == 'Y' and dist[j] == -1:
                dist[j] = dist[cur] + 1
                queue.append(j)

    # i의 2-친구 개수를 센다 (자기 자신 제외)
    count = sum(1 for j in range(N) if 0 < dist[j] <= 2)
    # 최대값 갱신
    max_2friends = max(max_2friends, count)

print(max_2friends)
