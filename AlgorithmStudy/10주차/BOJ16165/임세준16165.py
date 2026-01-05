N, M = map(int, input().split())
# 딕셔너리에 정보 모두 저장해놓고 조회로 해결
groupDict = {}
for _ in range(N):
    groupName = input()
    groupDict[groupName] = []
    memCount = int(input())
    for _ in range(memCount):
        memberName = input()
        # 그룹이름: [멤버명]
        # 멤버명: 그룹이름
        groupDict[groupName].append(memberName)
        groupDict[memberName] = groupName
    # 그룹이름으로 저장한 멤버리스트 정렬
    groupDict[groupName].sort()

for _ in range(M):
    question = input()
    qType = input()
    if qType=="0":
        for m in groupDict[question]:
            print(m)
    else:
        print(groupDict[question])
