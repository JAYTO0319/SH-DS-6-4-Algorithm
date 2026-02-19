import sys
from collections import defaultdict, deque
n, m, k, x = map(int, sys.stdin.readline().strip().split(' '))
num_dic = defaultdict(list)
for _ in range(m):
    s, e = map(int, sys.stdin.readline().strip().split(' '))
    num_dic[s].append(e)

num_queue = deque([x])
distance = [-1]*(n+1)
distance[x] = 0

while num_queue:
    curr_node = num_queue.popleft()
    for next_node in num_dic[curr_node]:
        if distance[next_node] == -1: #방문하지 않았으면 
            distance[next_node] = distance[curr_node]+1 #거리 추가
            num_queue.append(next_node)
is_k = False
for i in range(1, n+1):
    if distance[i] == k:
        print(i)
        is_k = True
if not is_k:
    print(-1)
