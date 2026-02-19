import sys
input = sys.stdin.readline

K, L = map(int, input().split())

# 학번(string) -> 마지막 클릭 순서(int) 저장
order = {}

for i in range(L):
    student = input().rstrip()
    order[student] = i  # 존재하면 덮어쓰기 -> 최신 순서 유지

# value(순서) 기준 오름차순 정렬
students = sorted(order.items(), key=lambda x: x[1])

# 결과 출력 — k명 또는 남아있는 학생 수만큼
for i in range(min(K, len(students))):
    print(students[i][0])
