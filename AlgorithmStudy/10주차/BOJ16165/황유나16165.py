n, m = map(int, input().split()) # 팀 수, 문제 수

group = {} # team : members
for _ in range(n):
    team = input()
    k = int(input())
    members = set() # in 연산을 빠르게 처리하기 위해 set 사용
    for _ in range(k):
        members.add(input())
    group[team] = members

for _ in range(m):
    quiz = input()
    num = int(input())
    if num == 0: # 모든 멤버 출력
        for member in sorted(list(group.get(quiz))): # 사전순으로 출력하기 위해 list로 변환 후 정렬
            print(member)
    else: # 팀 출력
        for team in group.keys():
            if quiz in group.get(team):
                print(team)
