import sys
input = sys.stdin.readline

n = int(input())
friends = [] # 친구여부 저장
for _ in range(n):
    friends.append(list(input().rstrip()))

max_cnt = 0  # 2-친구의 수 중 최대값
for i in range(n):
    count = 0
    for j in range(n):
        # 두 사람이 친구인 경우
        if friends[i][j] == 'Y':
            count += 1
        else: # friends[i][j] == 'N'
            if i == j: continue
            for k in range(n):
                # i와 j 모두 친구인 경우
                if friends[k][i] == 'Y' and friends[k][j] == 'Y':
                    count += 1
                    break # 중복 카운트 하지 않도록 빠져나옴
    # 최대 2-친구의 수 업데이트
    if count > max_cnt:
        max_cnt = count

print(max_cnt)
