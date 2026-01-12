import sys

# 입력:
# L (문자열 길이)
# 문자열
input = sys.stdin.readline

L = int(input().strip())
s = input().strip()

R = 31
MOD = 1234567891

# 누적 해시 값
h = 0

# R^i 값을 매번 pow로 만들지 말고, 누적 곱으로 관리한다.
# i=0이면 R^0 = 1
power = 1

for i in range(L):
    ch = s[i]

    # a -> 1, b -> 2, ..., z -> 26
    val = ord(ch) - ord('a') + 1

    # h = (h + val * R^i) mod MOD
    h = (h + val * power) % MOD

    # 다음 인덱스를 위해 power = power * R (mod MOD)
    power = (power * R) % MOD

print(h)
