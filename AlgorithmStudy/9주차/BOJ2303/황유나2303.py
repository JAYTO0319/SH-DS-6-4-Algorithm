import sys
from itertools import combinations
input = sys.stdin.readline

n = int(input()) # 사람 수
max_i = 0        # 이긴 사람
max_n = 0        # 최대값
for i in range(n):
    cards = list(map(int, input().split()))

    # 현재 최대값 찾기
    cur_n = 0
    for c in combinations(cards, 3):
        num = sum(c) % 10 # 합의 일의 자리 수
        if num > cur_n:
            cur_n = num
    
    # 전체 최대값 업데이트
    if cur_n >= max_n:
        max_i = i
        max_n = cur_n

print(max_i + 1)
