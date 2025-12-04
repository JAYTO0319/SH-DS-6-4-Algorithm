import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] sortArr = new int[N];		
		
		for(int i = 0 ; i < N; i ++) {
			sortArr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(sortArr);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < sortArr.length; i++) {
			sb.append(sortArr[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
