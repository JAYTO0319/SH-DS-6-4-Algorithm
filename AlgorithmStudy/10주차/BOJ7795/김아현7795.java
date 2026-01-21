import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 김아현7795 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		int T = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < T; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int N = Integer.parseInt(stringTokenizer.nextToken());
			int M = Integer.parseInt(stringTokenizer.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(stringTokenizer.nextToken());
			}
			Arrays.sort(A);
			
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(stringTokenizer.nextToken());
			}
			Arrays.sort(B);
			
			int count = 0;
			for(int a: A) {
				count += lowerBound(B, a);
			}
			System.out.println(count);
		}
	}
	private static int lowerBound(int[] arr, int target) {
		int low = 0; int high = arr.length;
		while(low < high) {
			int mid = (low + high) / 2;
			if(arr[mid] < target)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
}
