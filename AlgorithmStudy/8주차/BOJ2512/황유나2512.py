# 국가의 총 예산 내에서 최대 상한액을 이분탐색으로 찾기

n = int(input())
request = list(map(int, input().split()))
m = int(input()) # 국가예산 총액

start = 0          # 상한액의 최소값
end = max(request) # 상한액의 최대값
result = 0         # 배정된 예산

while start <= end:
    mid = (start + end) // 2 # 상한액
    total = sum([r if r < mid else mid for r in request]) # 지방별 배정된 예산의 총합
    if total <= m:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)
