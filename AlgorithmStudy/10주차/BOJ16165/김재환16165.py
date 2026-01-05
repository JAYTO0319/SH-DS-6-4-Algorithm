import sys
input = sys.stdin.readline

# N = 걸그룹 개수, M = 문제 개수
N, M = map(int, input().split())

# 팀 이름 -> 멤버 리스트 저장용
team_to_members = {}

# 멤버 이름 -> 소속 팀 이름 저장용
member_to_team = {}

# 걸그룹 정보 입력
for _ in range(N):
    team_name = input().strip()
    member_count = int(input().strip())

    # 이 팀의 멤버 리스트 초기화
    team_to_members[team_name] = []

    # 멤버 이름 입력
    for i in range(member_count):
        mem = input().strip()

        # 팀 -> 멤버 리스트에 추가
        team_to_members[team_name].append(mem)

        # 멤버 이름 -> 팀 이름으로 연결
        member_to_team[mem] = team_name

# 퀴즈 처리
for _ in range(M):
    query = input().strip()
    query_type = int(input().strip())

    # 0: team 이름이 주어지면 멤버 리스트를 사전순으로 출력
    if query_type == 0:
        # 정렬해서 출력
        for mem in sorted(team_to_members[query]):
            print(mem)

    # 1: member 이름이 주어지면 해당 팀명 출력
    else:
        print(member_to_team[query])
