from collections import deque

m, n = map(int, input().split())
tomato = []      # 토마토 상자
ripe = deque([]) # 익은 토마토 좌표
unripe = 0       # 안 익은 토마토 개수
day = 0          # 토마토를 모두 익히기 위한 최소 날짜

# 토마토 상태 입력받으면서 익은 토마토 좌표 저장하기
i = 0 # 행
for _ in range(n):
    row = [] # 토마토 한 줄(행)
    j = 0    # 열
    for t in map(int, input().split()):
        if t == 1:
            ripe.append((i, j, 1))
        elif t == 0:
            unripe += 1
        row.append(t)
        j += 1
    tomato.append(row)
    i += 1

move = [(-1, 0), (0, 1), (1, 0), (0, -1)] # 상, 우, 하, 좌
while ripe:
    # 토마토가 다 익으면 빠져나감
    if unripe == 0:
        break

    # 익은 토마토를 꺼내 주변에 안 익은 토마토 익히기
    x, y, d = ripe.popleft()
    day = d  # 걸린 날짜 업데이트
    for dx, dy in move:
        nx = x + dx
        ny = y + dy
        # 이동한 좌표가 유효하고, 안 익은 토마토인 경우 익히기
        if 0 <= nx < n and 0 <= ny < m and tomato[nx][ny] == 0:
            tomato[nx][ny] = 1
            ripe.append((nx, ny, d+1))
            unripe -= 1

if unripe > 0: # 토마토가 다 익을 수 없는 경우
    print(-1)
else:          # 토마토가 처음부터 다 익어있거나 다 익힐 수 있는 경우
    print(day)
