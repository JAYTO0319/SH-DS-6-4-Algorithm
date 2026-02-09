import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9461 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		long[] arr = new long[101];
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		arr[6] = 3;
		arr[7] = 4;
		arr[8] = 5;
		arr[9] = 7;
		arr[10] = 9;
		
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			for(int i=11; i<=N; i++) {
				arr[i] = arr[i-5] + arr[i-1];
			}
			sb.append(arr[N]).append("\n");
		}
		
		System.out.println(sb);
	}
}
