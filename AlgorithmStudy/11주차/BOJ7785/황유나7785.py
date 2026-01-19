import sys
input = sys.stdin.readline

n = int(input())
office = set()
for _ in range(n):
    name, log = input().split()
    if log == 'enter':
        office.add(name)
    else: # 'leave'
        office.discard(name)
for person in sorted(list(office), reverse=True):
    print(person)
