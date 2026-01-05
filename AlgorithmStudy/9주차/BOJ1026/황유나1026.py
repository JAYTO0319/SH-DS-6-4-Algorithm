n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort(reverse = True)

sum = 0
for aa, bb in zip(a, b):
    sum += aa * bb

print(sum)
