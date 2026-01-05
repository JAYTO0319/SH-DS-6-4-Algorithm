N = int(input())
friendDict = {}
result = 0

# 딕셔너리에 1차 친구 저장 (리스트로 해도 무방, 어차피 1~N번)
for i in range(N):
    friendDict[i] = []
    isFriendList = list(input())
    for j, v in enumerate(isFriendList):
        if v=="Y":
            friendDict[i].append(j)

# 딕셔너리를 키값으로 순회
for k in friendDict:
    friendOfK = friendDict[k]
    # 1차 친구 리스트를 집합으로 변경
    friendSet = set(friendOfK)
    # 2차 친구(1차 친구의 친구)까지 전부 가져와서 합집합
    for friend in friendOfK:
        friendSet = friendSet.union(set(friendDict[friend]))
    # 본인 제외
    friendSet.discard(k)
    # 2차 친구의 수 최댓값 구하기
    result = max(result, len(friendSet))
print(result)
