for _ in range(int(input())):
    N, M = map(int, input().split())
    A = sorted(list(map(int, input().split())), reverse=True)
    B = sorted(list(map(int, input().split())), reverse=True)
    result = 0
    j = 0
    for i in range(N):
        while j<len(B) and A[i]<=B[j]:
            j += 1
        result += len(B)-j
    print(result)
