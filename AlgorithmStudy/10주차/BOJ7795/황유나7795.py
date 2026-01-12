from bisect import bisect_left
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    alist = sorted(list(map(int, input().split())))
    blist = sorted(list(map(int, input().split())))

    total = 0
    for a in alist:
        total += bisect_left(blist, a)
    print(total)
