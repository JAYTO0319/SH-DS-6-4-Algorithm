import sys
import bisect
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    
    # B는 정렬해두기
    B.sort()
    
    ans = 0
    for a in A:
        # bisect_left(B, a)는 B에서 a보다 작은 수들의 개수
        # a보다 작은 값이 모두 왼쪽에 오므로 인덱스가 개수
        ans += bisect.bisect_left(B, a)
    
    print(ans)
