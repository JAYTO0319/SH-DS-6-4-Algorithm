import sys
from itertools import combinations

input = sys.stdin.readline

n = int(input().strip())

best_score = -1
best_idx = -1

for idx in range(1, n + 1):
    nums = list(map(int, input().split()))

    # 이 사람의 최대 점수를 구할 변수
    max_score = 0

    # combinations(nums, 3): nums에서 3개 조합을 모두 생성
    for a, b, c in combinations(nums, 3):
        # 합의 일의 자리
        score = (a + b + c) % 10
        # 이 사람의 최고 점수 갱신
        if score > max_score:
            max_score = score

    # 전체 최고 점수 갱신
    # 동점이면 번호가 큰 사람을 선택해야 하므로
    # 점수 > best_score인 경우 OR
    # 점수 == best_score AND idx > best_idx인 경우 갱신
    if max_score > best_score or (max_score == best_score and idx > best_idx):
        best_score = max_score
        best_idx = idx

print(best_idx)
