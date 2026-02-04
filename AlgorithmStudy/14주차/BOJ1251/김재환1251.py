# BOJ 1251 - 단어 나누기
#
# 문제:
#   문자열 S를 연속된 3부분으로 나눈다.
#   각 부분을 뒤집은 후 이어붙여서
#   사전순으로 가장 작은 문자열을 구하라.
#
# 접근:
#   - 가능한 모든 나누는 방법 (i, j)을 시도한다.
#     i는 A의 끝, j는 A+B의 끝.
#   - 각 부분을 분리한 뒤 역순으로 뒤집는다.
#   - 결과 문자열을 비교하면서 최소값을 찾는다.

s = input().rstrip()
n = len(s)

best = None  # 최소값을 저장할 변수

# i는 A의 길이 (1 ~ n-2)
for i in range(1, n - 1):
    # j는 A + B의 길이 (i+1 ~ n-1)
    for j in range(i + 1, n):

        # A = s[:i]
        # B = s[i:j]
        # C = s[j:]
        A = s[:i]
        B = s[i:j]
        C = s[j:]

        # 각 부분을 뒤집는다
        revA = A[::-1]
        revB = B[::-1]
        revC = C[::-1]

        # 이어붙인 문자열
        combined = revA + revB + revC

        # 최솟값 갱신
        if best is None or combined < best:
            best = combined

# 사전순 최소 문자열 출력
print(best)
