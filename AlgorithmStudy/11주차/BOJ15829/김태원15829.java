import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	final static long M = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String word = br.readLine();
		final long r = 31;
		long answer = 0;
		for (int i = 0; i < l; i++) {
			int a = word.charAt(i) - 'a' + 1;
			answer += (a * (fastPow(r, i))) % M;
			answer %= M;
		}
		System.out.println(answer);
	}
	
	private static long fastPow(long base, long x) {
		if (x == 0) return 1;
		if (x == 1) return base;
		long half = fastPow(base, x / 2);
		long result = half * half % M;
		if (x % 2 == 1) return result * base % M;
		return result;
	}

}
