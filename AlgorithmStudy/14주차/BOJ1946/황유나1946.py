import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    scores = []
    for _ in range(n):
        scores.append(tuple(map(int, input().split())))
    scores.sort()

    if n == 1:
        print(1)
    else:
        count = 1
        score = scores[0][1]
        for i in range(1, len(scores)):
            if scores[i][1] < score:
                count += 1
                score = scores[i][1]
        print(count)
