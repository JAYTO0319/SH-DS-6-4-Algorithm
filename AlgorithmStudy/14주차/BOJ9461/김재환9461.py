# BOJ 9461 - 파도반 수열
# n의 최대값은 100이므로,
# DP 배열도 100까지만 만들면 충분하다.

import sys
input = sys.stdin.readline

T = int(input())

# 모든 테스트케이스의 n을 저장
queries = [int(input()) for _ in range(T)]

# 필요한 DP 최대 범위
max_n = max(queries)

# dp[i] = P(i)
dp = [0] * (max_n + 1)

# 초기값 (문제에서 주어진 값)
dp[1] = 1
dp[2] = 1
dp[3] = 1

# n이 4 이상일 때만 필요한 값들
if max_n >= 4:
    dp[4] = 2
if max_n >= 5:
    dp[5] = 2

# 점화식 적용
# P(n) = P(n-2) + P(n-3)
for i in range(6, max_n + 1):
    dp[i] = dp[i - 2] + dp[i - 3]

# 결과 출력
for n in queries:
    print(dp[n])
