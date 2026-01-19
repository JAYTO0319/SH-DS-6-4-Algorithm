L = int(input())
i = 0
result = 0
for s in str(input()):
    result += ((ord(s) - ord('a') + 1) * (31 ** i))
    i += 1
print(result % 1234567891)
