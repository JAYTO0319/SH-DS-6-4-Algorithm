package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1543 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine().trim();
		String str2 = br.readLine().trim();
		int i=0, count=0;
		while(i<=str1.length()-str2.length()) {
			if(str1.substring(i, i+str2.length()).equals(str2)) {
				count++;
				i += str2.length();
			} else i++;
			
		}
		System.out.println(count);
	}
}
