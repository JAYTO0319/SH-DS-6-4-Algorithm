n, k =map(int, input().split())

idx = 0
arr = [i for i in range(1,n+1)]
result = []
r=0

while len(arr)>0:
    idx += k-1
    if idx>=len(arr):
        idx= idx % len(arr)
    result.append(arr.pop(idx))
print("<", end="")
for i in range(len(result)):
    if i == len(result)-1:
        print(result[i], end="")
        print(">")
    else:
        print(result[i], end=", ")  
