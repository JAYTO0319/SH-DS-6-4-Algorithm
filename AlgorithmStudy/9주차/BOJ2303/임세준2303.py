def combination(arr, r): # 조합 (확률과 통계)
    result = []
    if r==1:
        return [[n] for n in arr]
    for i, n in enumerate(arr):
        remain = arr[i+1:]
        combiRest = combination(remain, r-1)
        for combi in combiRest:
            result.append([n] + combi)
    return result

N = int(input())
hands = [list(map(int, input().split())) for _ in range(N)]
result = 0
maxi = 0

for i,deck in enumerate(hands):
    combi = combination(deck, 3)
    maxCombi = max(map(lambda n : sum(n)%10, combi)) # 조합 결과 순회하면서 다 더한 후 1의 자리 최댓값 구함  
    if maxi<=maxCombi: # 기존 최댓값 이상인 경우 result 갱신
        result = i+1
        maxi = maxCombi

print(result)
