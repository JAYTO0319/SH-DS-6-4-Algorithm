import sys
input = sys.stdin.readline

# ---------------------- 입력 받기 ----------------------
N = int(input().rstrip())
words = [input().rstrip() for _ in range(N)]  # 알파벳 소문자로 된 단어들

# ---------------------- 중복 제거 ----------------------
# 같은 단어 여러 번 입력되어도 한 번만 출력해야 하므로 set 사용
words = list(set(words))

# ---------------------- 정렬: 길이순 → 길이 같으면 사전순 ----------------------
# 파이썬 sort의 key로 튜플 (len(word), word) 주면
#   첫번째: 길이 오름차순
#   두번째: 길이가 같을 경우 사전순 자동
words.sort(key=lambda w: (len(w), w))

# ---------------------- 출력 ----------------------
# 정렬 후 그대로 한 줄씩 출력
print("\n".join(words))
