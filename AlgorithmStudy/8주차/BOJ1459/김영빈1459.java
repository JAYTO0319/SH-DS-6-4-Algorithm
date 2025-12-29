import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		long w = Long.parseLong(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		
		long result = 0;
		
		if(2 * w < s) {
			result = w * (x + y);
		} else {
			if(x>0 && y>0) {
				long diff = x > y ? y : x;
				result += diff * s;
				x -= diff;
				y -= diff;
			}
			if(x==0 || y==0) {
				long last = x==0 ? y : x;
				if(w<s) {
					result += w * last;
				} else {
					long q = last/2;
					long r = last%2;
					result += q * 2 * s + r * w;
				}
			}
		}
		System.out.println(result);
	}
}
