import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// 백준 9461 파도반 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long [101];
			arr[0] = 0;
			arr[1] = 1;
			arr[2] = 1;
			for (int i = 3; i < n + 1; i++) {
				arr[i] = arr[i - 3] + arr[i - 2];
			}
			sb.append(arr[n]).append("\n");
		}
		System.out.print(sb);
	}

}
