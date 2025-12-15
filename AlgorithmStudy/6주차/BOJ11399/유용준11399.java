package com.shinhan.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11399 {

	public static void main(String[] args) throws IOException {
		// 백준 111399 ATM
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int [n + 1];
		arr[0] = 0;
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i] + arr[i - 1];
			sum += arr[i];
		}
		System.out.println(sum);
		
	}

}
