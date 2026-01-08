import sys
input = sys.stdin.readline

def ccw(ax, ay, bx, by, cx, cy):
    """
    CCW(orientation) 판정
    (B-A) x (C-A) = (bx-ax)*(cy-ay) - (by-ay)*(cx-ax)
    반환:
      +1 : 반시계(양수)
      -1 : 시계(음수)
      0  : 일직선(이 문제에서는 발생하지 않는다고 가정)
    """
    v = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax)
    if v > 0:
        return 1
    elif v < 0:
        return -1
    else:
        return 0

def intersect(ax, ay, bx, by, cx, cy, dx, dy):
    """
    선분 AB 와 선분 CD 가 교차하면 True.
    이 문제(17386)는 '세 점이 일직선'인 경우가 없으므로
    ccw == 0 케이스(끝점 접촉/일직선 겹침 등)를 따로 처리할 필요가 없다.
    """
    ab_c = ccw(ax, ay, bx, by, cx, cy)
    ab_d = ccw(ax, ay, bx, by, dx, dy)
    cd_a = ccw(cx, cy, dx, dy, ax, ay)
    cd_b = ccw(cx, cy, dx, dy, bx, by)

    return (ab_c * ab_d < 0) and (cd_a * cd_b < 0)

x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

print(1 if intersect(x1, y1, x2, y2, x3, y3, x4, y4) else 0)
