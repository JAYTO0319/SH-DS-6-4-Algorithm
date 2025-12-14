import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1543 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String docs = br.readLine();
		String search = br.readLine();
		
		int cnt = 0;
		
		int startIdx = 0;
		int endIdx = search.length()-1;
		
		while(endIdx < docs.length()) {
			String subDocs = docs.substring(startIdx, endIdx+1);
			if(subDocs.equals(search)) {
				startIdx += search.length();
				endIdx += search.length();
				cnt ++;
			} else {
				startIdx++;
				endIdx++;
			}
		}
		
		System.out.println(cnt);
	}

}
