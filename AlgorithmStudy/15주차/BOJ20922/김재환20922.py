import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))

cnt = [0] * 100001
left = 0
right = 0
answer = 0

while right < N:
    # 현재 right에 있는 숫자 개수를 추가해도 K개 이하라면
    if cnt[arr[right]] < K:
        cnt[arr[right]] += 1
        right += 1
        answer = max(answer, right - left)
    else:
        # 넘친다면 left를 하나씩 줄인다
        cnt[arr[left]] -= 1
        left += 1

print(answer)
