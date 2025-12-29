import sys
from collections import deque
input = sys.stdin.readline

N = int(input().strip())
population = list(map(int, input().split()))
adj = [[] for _ in range(N)]
for i in range(N):
    data = list(map(int, input().split()))
    for j in range(1, len(data)):
        adj[i].append(data[j] - 1)

def is_connected(group):
    if not group:
        return False
    visited = set([group[0]])
    queue = deque([group[0]])
    while queue:
        cur = queue.popleft()
        for nxt in adj[cur]:
            if nxt in group and nxt not in visited:
                visited.add(nxt)
                queue.append(nxt)
    return len(visited) == len(group)

answer = float('inf')

# 비트마스크로 모든 분할 확인
for mask in range(1, 1 << N):
    group1 = []
    group2 = []
    for i in range(N):
        if mask & (1 << i):
            group1.append(i)
        else:
            group2.append(i)

    # 두 그룹 모두 비어있지 않아야 함
    if not group1 or not group2:
        continue

    # 각각 연결인지 검사
    if is_connected(group1) and is_connected(group2):
        pop1 = sum(population[i] for i in group1)
        pop2 = sum(population[i] for i in group2)
        answer = min(answer, abs(pop1 - pop2))

print(answer if answer != float('inf') else -1)
