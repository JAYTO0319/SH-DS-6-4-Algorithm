import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ' && c != -1);
            long sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static int ccw(long ax, long ay, long bx, long by, long cx, long cy) {
        /*
          CCW(orientation) 판정: (B-A) x (C-A)
          long 사용 이유: 좌표 범위가 커도 외적 계산에서 int 오버플로우 방지
        */
        long v = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
        if (v > 0) return 1;
        if (v < 0) return -1;
        return 0; // 이 문제에서는 '세 점 일직선 없음' -> 사실상 발생하지 않음
    }

    static boolean intersect(long ax, long ay, long bx, long by,
                             long cx, long cy, long dx, long dy) {

        int ab_c = ccw(ax, ay, bx, by, cx, cy);
        int ab_d = ccw(ax, ay, bx, by, dx, dy);
        int cd_a = ccw(cx, cy, dx, dy, ax, ay);
        int cd_b = ccw(cx, cy, dx, dy, bx, by);

        // 17386: 일직선(0) 케이스가 없다고 했으므로 < 0만 체크하면 된다.
        return (ab_c * ab_d < 0) && (cd_a * cd_b < 0);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        long x1 = fs.nextLong();
        long y1 = fs.nextLong();
        long x2 = fs.nextLong();
        long y2 = fs.nextLong();

        long x3 = fs.nextLong();
        long y3 = fs.nextLong();
        long x4 = fs.nextLong();
        long y4 = fs.nextLong();

        System.out.println(intersect(x1, y1, x2, y2, x3, y3, x4, y4) ? 1 : 0);
    }
}
