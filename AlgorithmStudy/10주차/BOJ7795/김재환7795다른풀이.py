import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    A.sort()
    B.sort()

    cnt = 0
    j = 0
    # A, B 둘 다 정렬되어 있으므로 투포인터 활용
    for i in range(N):
        while j < M and A[i] > B[j]:
            j += 1
        cnt += j  # B[0..j-1] 까지는 A[i]보다 작다

    print(cnt)
