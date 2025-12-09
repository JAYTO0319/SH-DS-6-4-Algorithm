def check(maxSize, lectures, M):
    count,curSize = 1, 0
    for lecture in lectures:
        if curSize+lecture>maxSize:
            count+=1
            curSize = lecture
        else:
            curSize += lecture
    # print(count, M)
    return count<=M

N,M = map(int,input().split())
lectures = list(map(int,input().split()))
s, e = max(lectures), sum(lectures)
while s<e:
    mid = (s + e) // 2
    if check(mid, lectures, M):
        e = mid
    else:
        s = mid + 1
print(e)
