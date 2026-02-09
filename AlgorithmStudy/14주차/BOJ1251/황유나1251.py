str = input()
result = 'z' * len(str)
for i in range(1, len(str) - 1):
    for j in range(i + 1, len(str)):
        temp = str[:i][::-1] + str[i:j][::-1] + str[j:][::-1]
        if result > temp:
            result = temp

print(result)
