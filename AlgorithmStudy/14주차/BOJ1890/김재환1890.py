# BOJ 1890 - 점프

import sys
input = sys.stdin.readline

# 입력
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

# dp[r][c] = (r,c) 위치에 도달할 수 있는 경우의 수
# 0으로 초기화
dp = [[0] * N for _ in range(N)]

# 시작점은 하나의 경로로 시작할 수 있음
dp[0][0] = 1

# 각각의 칸을 순회하면서 경로를 누적
for r in range(N):
    for c in range(N):

        # dp[r][c] = 이 칸까지 도달 가능한 경로 수
        count = dp[r][c]
        if count == 0:
            # 이 칸에 올 수 없으면 다음으로 넘어감
            continue

        jump = board[r][c]
        if jump == 0:
            # 값이 0이면 더 이상 이동 불가
            # (끝 점이거나 이동이 막힌 상태)
            continue

        # 오른쪽 이동
        nr = r
        nc = c + jump
        if nc < N:
            dp[nr][nc] += count

        # 아래쪽 이동
        nr = r + jump
        nc = c
        if nr < N:
            dp[nr][nc] += count

# 결과는 (N-1, N-1) 위치에 누적된 경로 수
print(dp[N-1][N-1])
