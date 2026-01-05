package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Integer[] A = new Integer[n];
		Integer[] B = new Integer[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += A[i]*B[i];
		}
		System.out.println(sum);

	}

}
