import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1251 {

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		List<String> list = new ArrayList<>();
		
		StringBuilder sb;
		
		for(int i=1; i<=str.length()-2; i++) {
			for(int j=i+1; j<=str.length()-1; j++) {
				sb = new StringBuilder();
				sb.append(toReverse(str.substring(0, i)));
				sb.append(toReverse(str.substring(i,j)));
				sb.append(toReverse(str.substring(j, str.length())));
				list.add(sb.toString());
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));
	}

	private static String toReverse(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s).reverse();
		return sb.toString();
	}
}
