n, k = map(int, input().split())
money = []
for _ in range(n):
    money.append(int(input()))

total = 0
for m in money[::-1]: # 내림차순으로 접근
    if k == 0: break
    total += k // m
    k %= m

print(total)
