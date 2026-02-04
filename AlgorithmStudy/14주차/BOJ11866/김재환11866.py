# BOJ 11866 - 요세푸스 문제 0

import sys
input = sys.stdin.readline

# 입력: N, K
# N = 사람 수
# K = 누를 때마다 K번째 사람 제거
n, k = map(int, input().split())

# 리스트로 1~n까지 초기화
# 파이썬 리스트를 큐처럼 사용
people = list(range(1, n + 1))

# 결과를 저장할 리스트
result = []

# 현재 인덱스
idx = 0

# 모든 사람이 제거될 때까지 반복
while people:
    # 현재 위치 기준으로 k번째 제거 위치 계산
    # (idx + (k-1)) % 남은 사람 수
    idx = (idx + (k - 1)) % len(people)

    # 제거될 사람을 결과에 추가
    result.append(str(people.pop(idx)))

# 출력 형식: <1, 2, 3, ...>
print("<" + ", ".join(result) + ">")
