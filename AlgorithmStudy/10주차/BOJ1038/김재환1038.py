import sys
input = sys.stdin.readline

N = int(input().strip())

# 모든 감소하는 수를 저장할 리스트
decreasing = []

# 백트래킹 함수
# num: 현재 숫자, last: 마지막 자릿수 숫자
def backtrack(num, last):
    # 현재까지 만들어진 감소하는 수를 리스트에 저장
    decreasing.append(num)

    # 다음 자릿수는 last보다 작은 수만 붙임
    for nxt in range(last):
        # 다음 숫자를 num*10 + nxt로 만들면서 재귀 호출
        backtrack(num * 10 + nxt, nxt)

# 0~9 한 자리 감소하는 수부터 시작
for d in range(10):
    backtrack(d, d)

# 정렬
decreasing.sort()

# 범위 확인 후 출력
if N >= len(decreasing):
    print(-1)
else:
    print(decreasing[N])
