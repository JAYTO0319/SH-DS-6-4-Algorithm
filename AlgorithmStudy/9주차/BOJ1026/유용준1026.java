package com.shinhan.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1026 {

	public static void main(String[] args) throws IOException {
		// 백준 1026 보물
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int [n];
		int[] arr2 = new int [n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr2);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[n - 1 - i] * arr2[i];
		}
		System.out.println(sum);
	}

}
