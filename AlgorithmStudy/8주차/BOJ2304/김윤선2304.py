#n개 빌딩
#위치: L 높이: H
#위치:높이 => dic
#위치 기준 전에 높은 게 없으면 자기 높이, 있으면 그 높이
#가장 높은 기둥을 지나면 거꾸로=>오목하지 않기 위함
import sys

n = int(sys.stdin.readline().strip())

n_dic = {}
for _ in range(n):
    l, h = map(int , sys.stdin.readline().strip().split(" "))
    n_dic[l] = h

sorted_ndic = sorted(n_dic.items(), key=lambda x:x[0])

#넓이를 저장
total = 0

#가장 높은 높이
lh = max(n_dic.values())
#가장 높은 높이의 위치 리스트
lh_list = [l for l, h in n_dic.items() if h == lh]

sorted_l = [x[0] for x in sorted_ndic]

first = sorted_l.index(min(lh_list))
last = sorted_l.index(max(lh_list))


prev_l , prev_h = sorted_ndic[0]

#0~가장 높은 높이의 위치
for l, h in sorted_ndic[1:first+1]:
    if h>prev_h:
        total+= (l-prev_l)*prev_h
        prev_h = h
        prev_l = l


prev_l, prev_h= sorted_ndic[-1]

#마지막~ 가장 높은 높이의 위치
for l, h in sorted_ndic[-2:last-1:-1]:
    if h>prev_h:
        total = total+ (prev_l-l)*prev_h
        prev_h = h
        prev_l = l
  

total+=(max(lh_list)-min(lh_list)+1)*lh

print(total)
