package algorithm.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 김영빈1181 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		while(N-->0) {
			set.add(br.readLine());
		}
		
		String[] str;
		str = set.toArray(new String[0]);
		
		Arrays.sort(str, (s1,s2)->{
			if(s1.length()!= s2.length()) return s1.length() - s2.length();
			else return s1.compareTo(s2);
		});
		
		for(String s : str) {
			sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}

}
