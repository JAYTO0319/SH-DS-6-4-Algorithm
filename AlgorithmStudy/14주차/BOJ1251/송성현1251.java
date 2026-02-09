import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<String> list1 = new ArrayList<String>();
		// 1 2 3~
		// 1 2 4~
		// 1 2 5~
		//...
		// 1 3 4~
		// 1 3 5~
		// 1 3 6~
		//...
		// 1 4 5~
		// 1 4 6~
		// 1 4 7~
		//...
		// 1 5 6~
		for(int i=1; i<str.length()-2; i++) {
			for(int j=i+1; j<str.length(); j++) {
				String str1 = str.substring(0,i);
				String str2 = str.substring(i,j);
				String str3 = str.substring(j,str.length());
				
				String revstr1 = "";
				String revstr2 = "";
				String revstr3 = "";
				String result = "";
				
				for(int num = str1.length()-1; num >= 0; num--) {
					revstr1 += str1.charAt(num);
				}
				//System.out.println("1번 : " + revstr1);
				for(int num = str2.length()-1; num >= 0; num--) {
					revstr2 += str2.charAt(num);
				}
				//System.out.println("2번 : " + revstr2);
				for(int num = str3.length()-1; num >= 0; num--) {
					revstr3 += str3.charAt(num);
				}
				//System.out.println("3번 : " + revstr3);
				
				result = revstr1 + revstr2 + revstr3;
				
				list1.add(result);
			}
		}
		//System.out.println(list1);
		Collections.sort(list1);
		System.out.println(list1.get(0));
	}
}
