import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

# dp[r][c][d]
# d: 0=가로, 1=세로, 2=대각선
dp = [[[0]*3 for _ in range(N)] for _ in range(N)]

# 시작 상태: (0,0)-(0,1) 가로
dp[0][1][0] = 1

for r in range(N):
    for c in range(N):
        if board[r][c] == 1:
            continue

        # 가로
        if c-1 >= 0:
            dp[r][c][0] += dp[r][c-1][0]
            dp[r][c][0] += dp[r][c-1][2]

        # 세로
        if r-1 >= 0:
            dp[r][c][1] += dp[r-1][c][1]
            dp[r][c][1] += dp[r-1][c][2]

        # 대각선
        if r-1 >= 0 and c-1 >= 0:
            if board[r-1][c] == 0 and board[r][c-1] == 0:
                dp[r][c][2] += dp[r-1][c-1][0]
                dp[r][c][2] += dp[r-1][c-1][1]
                dp[r][c][2] += dp[r-1][c-1][2]

print(sum(dp[N-1][N-1]))
