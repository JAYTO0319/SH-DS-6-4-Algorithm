package algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

//백준 1920

//// 풀이1_해시셋 사용
//public class Week5_3 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		HashSet<Integer> hs = new HashSet<Integer>();
//		while(n-- > 0) {
//			hs.add(Integer.parseInt(st.nextToken()));
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		
//		int m = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		while(m-- > 0) {
//			sb.append(hs.contains(Integer.parseInt(st.nextToken())) ? "1" : "0").append("\n");
//		}
//		System.out.println(sb);
//	}
//	
//}


//풀이2_이분 탐색
public class Week5_3 {
	
	public static boolean isExist(int[] arr, int num) {
		
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] < num) {
				left = mid + 1;
			}else if(arr[mid] > num) {
				right = mid - 1;
			}else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(m-- > 0) {
			sb.append(isExist(arr, Integer.parseInt(st.nextToken())) ? "1" : "0").append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
