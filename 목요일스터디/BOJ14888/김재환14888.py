import sys
input = sys.stdin.readline

def dfs(idx, current):
    global max_val, min_val

    # 모든 연산자를 사용한 경우
    if idx == N - 1:
        max_val = max(max_val, current)
        min_val = min(min_val, current)
        return

    # 덧셈
    if ops[0] > 0:
        ops[0] -= 1
        dfs(idx + 1, current + nums[idx + 1])
        ops[0] += 1

    # 뺄셈
    if ops[1] > 0:
        ops[1] -= 1
        dfs(idx + 1, current - nums[idx + 1])
        ops[1] += 1

    # 곱셈
    if ops[2] > 0:
        ops[2] -= 1
        dfs(idx + 1, current * nums[idx + 1])
        ops[2] += 1

    # 나눗셈
    if ops[3] > 0:
        ops[3] -= 1
        # 파이썬 특성상 음수 // 양수는 올림 방향 → 문제 조건에 맞게 처리
        if current < 0:
            dfs(idx + 1, -(-current // nums[idx + 1]))
        else:
            dfs(idx + 1, current // nums[idx + 1])
        ops[3] += 1


# 입력
N = int(input())
nums = list(map(int, input().split()))
ops = list(map(int, input().split()))

max_val = -10**18
min_val = 10**18

dfs(0, nums[0])

print(max_val)
print(min_val)
