from itertools import permutations
import sys

n, k = map(int, sys.stdin.readline().split(' '))
kits = list(map(int, sys.stdin.readline().split(' ')))

count = 0 #가능한 조합의 개수
for i in permutations(kits, n):
    total = 500
    if i[0] - k < 0:
        continue
    for j in i:
        total += j - k
        if total < 500:
            break
    else:
        count += 1
print(count)
