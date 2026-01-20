import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		long r = 1;
		long M = 1234567891;
		
		long hash = 0;
		
		for(int i=0; i<L; i++) {
			hash += ((arr[i] - 96) * r);
			r = (31 * r) % M;
		}
		hash %= M;
		System.out.println(hash);
	}

}
