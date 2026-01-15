#최대한으로 놀 수 있는 날을 구하기
#그리디 순회공연이랑 비슷한 듯
#n개 줄
#d:과제하는데 걸리는 일
#t:마감일
#과제를 적어도 해야하는 날: t-d
#과제의 마감일이 늦은 것부터 처리
import sys
n = int(sys.stdin.readline())
task=[]
for i in range(n):
    d, t = map(int, sys.stdin.readline().split())
    task.append((d, t))

task.sort(key=lambda x: x[1], reverse=True)
restdays= task[0][1]-task[0][0]

for i in range(1, n):
    d, t = task[i]
    t = min(t, restdays)
    restdays = t - d
print(restdays)
