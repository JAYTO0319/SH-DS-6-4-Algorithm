import java.io.*;
import java.math.BigInteger;

public class Main {
    //왜 선형대수 생각을 못했지...
    static class Matrix {
        BigInteger[][] a = new BigInteger[3][3];

        Matrix() {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    a[i][j] = BigInteger.ZERO;
        }
    }

    // 행렬 곱
    static Matrix multiply(Matrix x, Matrix y) {
        Matrix r = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    r.a[i][j] = r.a[i][j].add(
                            x.a[i][k].multiply(y.a[k][j])
                    );
                }
            }
        }
        return r;
    }

    // 행렬 거듭제곱
    static Matrix power(Matrix m, int exp) {
        Matrix r = new Matrix();
        for (int i = 0; i < 3; i++) r.a[i][i] = BigInteger.ONE;

        while (exp > 0) {
            if ((exp & 1) == 1) r = multiply(r, m);
            m = multiply(m, m);
            exp >>= 1;
        }
        return r;
    }

    static BigInteger padovan(int n) {
        if (n <= 3) return BigInteger.ONE;

        Matrix base = new Matrix();
        base.a[0][1] = BigInteger.ONE;
        base.a[0][2] = BigInteger.ONE;
        base.a[1][0] = BigInteger.ONE;
        base.a[2][1] = BigInteger.ONE;

        Matrix res = power(base, n - 3);

        // P(n) = res[0][0]*P(3) + res[0][1]*P(2) + res[0][2]*P(1)
        return res.a[0][0]
                .add(res.a[0][1])
                .add(res.a[0][2]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(padovan(n)).append('\n');
        }
        System.out.print(sb);
    }
}
