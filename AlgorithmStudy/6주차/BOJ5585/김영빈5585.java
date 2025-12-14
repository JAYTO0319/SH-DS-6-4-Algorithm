import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5585 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int rem = 1000 - N;
		int cnt = 0;
		
		int[] comp = {500,100,50,10,5,1};
		int idx = 0;
		
		while(idx < comp.length) {
			if(rem>=comp[idx]) {
				rem -= comp[idx];
				cnt++;
			} else {
				idx++;
			}
		}
		System.out.println(cnt);
	}
}
