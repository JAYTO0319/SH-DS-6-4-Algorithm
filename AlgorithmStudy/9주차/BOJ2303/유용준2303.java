package com.shinhan.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2303 {

	public static void main(String[] args) throws IOException {
		// 백준 2303 숫자 게임
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr = new int [5];
		int max = 0;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < arr.length; j++) {
				for (int a = 0; a < arr.length; a++) {
					for (int b = 0; b < arr.length; b++) {
						int sum = 0;
						if (j!= a && a != b && j != b) {
							sum += arr[j] + arr[a] + arr[b];
						}
						if (sum % 10 >= max) {
							max = sum % 10;
							ans = i + 1;
						}
					}
				}
			}
		}
		System.out.println(ans);

	}

}
