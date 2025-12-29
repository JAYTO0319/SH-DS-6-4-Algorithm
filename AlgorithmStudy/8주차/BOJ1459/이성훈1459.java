package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1459 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		long big, small;
		if(x>y) {
			big = x;
			small = y;
		}else {
			big = y;
			small = x;
		}
		long gap = big - small;
		
		if(2*w < s) {
			System.out.println((big + small)*w);
		}else if(w < s){
			System.out.println(small * s + gap * w);
		}else{
			System.out.println(small * s + (gap / 2) * 2 * s + (gap % 2) * w);
		}
	}

}
