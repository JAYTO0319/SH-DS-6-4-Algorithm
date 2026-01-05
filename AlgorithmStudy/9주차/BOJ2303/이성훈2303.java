package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2303 {
	
	public static int getMax(int[] arr) {
		int max = -1;
		for(int i = 0; i < 3; i++) {
			for(int j = i + 1; j < 4; j++) {
				for(int k = j + 1; k < 5; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					max = Math.max(max, sum%10);
				}
			}
		}
		
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxValue = -1;
		int maxIndex = -1;
		
		for(int i = 0; i< n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[5];
			for(int j = 0; j < 5; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int curValue = getMax(arr);
			if(maxValue <= curValue) {
				maxValue = curValue;
				maxIndex = i;
			}
		}
		System.out.println(maxIndex+1);
	}

}
