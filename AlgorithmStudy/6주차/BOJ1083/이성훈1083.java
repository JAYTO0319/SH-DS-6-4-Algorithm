import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1083 {
	
	public static int[] arr;
	public static int n;
	public static int s;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		s = Integer.parseInt(br.readLine());
		
		int countSorted = 0;
		while(s > 0) {
			if(countSorted == arr.length) {
				break;
			}
			
			int max = 0;
			int target = 0;
			int tmp = Math.min(s, arr.length - 1 - countSorted);
			for(int i = countSorted; i <= countSorted + tmp; i++) {
				if(max<arr[i]) {
					max = arr[i];
					target = i;
				}
			}
			for(int i = target; i > countSorted; i--) {
				int temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
				s--;
			}
			countSorted++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
		
	}

}
