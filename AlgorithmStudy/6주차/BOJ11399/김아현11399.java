import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 김아현11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		
		int N = Integer.parseInt(bufferedReader.readLine());
		int[] arr = new int[N];
		int sum = 0; int result = 0;
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			result += sum;
		}
		
		System.out.println(result);
	}
}


