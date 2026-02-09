import sys
input = sys.stdin.readline

def dfs(day, weight):
    global ans
    # 무게가 500 아래면 바로 종료
    if weight < 500:
        return
    # N일 모두 채웠으면 경우 수 증가
    if day == N:
        ans += 1
        return
    # 모든 키트 순열 생성
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            next_weight = weight - K + kits[i]
            dfs(day + 1, next_weight)
            visited[i] = False

N, K = map(int, input().split())
kits = list(map(int, input().split()))
visited = [False] * N
ans = 0

dfs(0, 500)
print(ans)
