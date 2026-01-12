package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		int cursorIdx = sb.length();
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("P")) {
				String s2 = st.nextToken();
				sb.insert(cursorIdx, s2);
				cursorIdx++;
				continue;
			}
			if(s.equals("L")) {
				cursorIdx--;
				if(cursorIdx<0)cursorIdx=0;
				continue;
			}
			if(s.equals("D")) {
				cursorIdx++;
				if(cursorIdx>sb.length()) cursorIdx = sb.length();
				continue;
			}
			if(s.equals("B")) {
				if(cursorIdx==0) continue;
				sb.deleteCharAt(--cursorIdx);
			}
			
		}
		System.out.println(sb);
		
	}

}
