import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] d = new long[101];
		d[1] = d[2] = d[3] = 1;
		d[4] = d[5] = 2;
		d[6] = 3; d[7] = 4; d[8] = 5;
		for (int i = 9; i < 101; i++) {
			d[i] = d[i - 1] + d[i - 5];
		}
		while (T-->0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(d[n]).append("\n");
		}
		System.out.println(sb);
	}

}
