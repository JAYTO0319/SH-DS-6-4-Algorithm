import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7795 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[] A;
		int[] B;
		
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			A = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			B = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(B);
			
			int sum = 0;
			for(int i=0; i<N; i++) {
				int left = 0;
				int right = B.length-1;
				int idx = -1;
				
				while(left<=right) {
					int mid = (left+right)/2;
					if(B[mid]<A[i]) {
						idx = mid;
						left = mid+1;
					} else {
						right = mid-1;
					}
				}
				if(idx!=-1) {
					sum += idx+1;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
