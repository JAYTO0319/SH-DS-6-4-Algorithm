from bisect import bisect_left
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    blist = sorted(list(map(int, input().split())))

    total = 0
    for a in alist:
        total += bisect_left(blist, a) # 정렬된 blist에서 순서상 a가 들어갈 수 있는 가장 왼쪽 인덱스 반환
    print(total)
