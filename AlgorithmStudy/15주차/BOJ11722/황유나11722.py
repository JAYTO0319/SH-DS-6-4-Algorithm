n = int(input())
num = list(map(int, input().split()))

memo = [1 for _ in range(n)]
for i in range(1, len(num)):
    for j in range(0, i):
        if num[j] > num[i]:
            memo[i] = max(memo[i], memo[j] + 1)

print(max(memo))
