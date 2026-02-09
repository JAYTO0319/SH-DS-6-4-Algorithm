# BOJ 1946 - 신입 사원
#
# 핵심 요약:
#   (서류, 면접) 두 순위가 주어진다.
#   어떤 사람 A가 사람 B보다 서류도 좋고 면접도 좋다면(B는 두 점수 모두 더 큼) B는 절대 뽑히지 못한다.
#   가능한 최대 선발 인원을 구한다.
#
# 그리디 핵심:
#   1) 서류 순위 오름차순 정렬
#   2) 앞에서부터 보면서 '현재까지의 면접 최고(=숫자 최솟값)'를 유지
#   3) 지금 사람의 면접 순위가 그 최솟값보다 더 좋으면 선발, 아니면 탈락
#
# 왜 이게 맞나?
#   서류 오름차순으로 보면,
#     지금 사람보다 서류가 더 좋은 사람은 무조건 앞쪽에만 존재한다.
#   그러므로 지금 사람을 떨어뜨릴 수 있는 후보는 "앞쪽 사람"뿐.
#   그 중 면접까지 더 좋은 사람이 하나라도 있으면(면접 순위가 더 작으면) 지금 사람은 지배당해 탈락.
#   따라서 앞쪽 사람들의 면접 최솟값만 알면 판정이 끝난다.

import sys
input = sys.stdin.readline

T = int(input())
out_lines = []

for _ in range(T):
    n = int(input())
    arr = [tuple(map(int, input().split())) for _ in range(n)]

    # 1) 서류 순위 기준 오름차순
    arr.sort(key=lambda x: x[0])

    # 2) 첫 사람은 무조건 뽑힌다.
    #    이유: 서류 1등은 서류로는 누구에게도 지지 않는다.
    count = 1
    best_interview = arr[0][1]  # 지금까지 본 사람 중 가장 좋은(=가장 작은) 면접 순위

    # 3) 두 번째 사람부터 검사
    for i in range(1, n):
        interview = arr[i][1]

        # 지금 사람의 면접 순위가 더 좋다면(숫자가 더 작다면)
        # 앞사람들 중 면접에서 이길 사람이 없으므로 지배당하지 않는다 -> 선발 가능
        if interview < best_interview:
            count += 1
            best_interview = interview

        # interview >= best_interview 라면
        # 이미 앞에 "서류도 더 좋고(정렬상) 면접도 더 좋은" 사람이 존재 -> 현재 사람은 탈락
        # (따로 count를 늘리지 않는다)

    out_lines.append(str(count))

print("\n".join(out_lines))
