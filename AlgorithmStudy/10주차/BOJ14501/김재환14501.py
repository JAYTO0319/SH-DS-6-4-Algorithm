# 퇴사 (14501번)

import sys
input = sys.stdin.readline

N = int(input())
# 상담 기간과 보상 리스트
T = [0] * (N + 1)
P = [0] * (N + 1)

for i in range(1, N+1):
    t, p = map(int, input().split())
    T[i] = t
    P[i] = p

# dp[i] = i일부터 끝까지 벌 수 있는 최대 이익
dp = [0] * (N + 2)

for i in range(N, 0, -1):
    # 상담 종료 날짜
    finish = i + T[i]

    # 상담이 범위 내에 끝나면
    if finish <= N + 1:
        # 상담을 받는 경우 vs 받지 않는 경우 비교
        dp[i] = max(P[i] + dp[finish], dp[i+1])
    else:
        # 상담이 기간 오버하면 무조건 받지 않음
        dp[i] = dp[i+1]

print(dp[1])
