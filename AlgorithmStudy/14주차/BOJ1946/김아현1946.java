import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 김아현1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			int count = 1;
			
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				arr[paper] = Integer.parseInt(st.nextToken());
			}
			
			int min = arr[1];
				
			for(int k = 2; k <= N; k++) {
				if(arr[k] < min) {
					count++;
					min = arr[k];
				}
			}
			System.out.println(count);
		}
	}
}
