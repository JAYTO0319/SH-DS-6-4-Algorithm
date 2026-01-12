import sys

# 많은 입력을 빠르게 처리하기 위해
input = sys.stdin.readline

# 로그 개수
n = int(input())

# 현재 회사에 있는 사람을 저장할 집합
# enter -> 추가, leave -> 삭제
now = set()

for _ in range(n):
    name, action = input().split()

    # enter이면 set에 추가
    if action == "enter":
        now.add(name)
    else:
        # leave이면 set에서 삭제
        now.remove(name)

# 사전 순의 역순으로 정렬
# sorted()에 reverse=True를 붙이면 내림차순 정렬
ans = sorted(now, reverse=True)

# 출력
for name in ans:
    print(name)
