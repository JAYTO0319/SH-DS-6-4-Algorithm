import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

n = int(input())
miro = []
visited = [[0] * n for _ in range(n)]
for _ in range(n):
    row = list(map(int, input().split()))
    miro.append(row)

visited[n - 1][n - 1] = 1
for i in range(n - 1, -1, -1):
    for j in range(n - 1, -1, -1):
        if i == n - 1 and j == n - 1:
            continue
        k = miro[i][j]
        l = 0
        m = 0
        if i + k < n:
            l = visited[i + k][j]
        if j + k < n:
            m = visited[i][j + k]
        visited[i][j] = l + m

print(visited[0][0])
