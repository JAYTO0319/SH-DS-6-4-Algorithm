import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double x1 = Double.parseDouble(st.nextToken());
		double y1 = Double.parseDouble(st.nextToken());
		double x2 = Double.parseDouble(st.nextToken());
		double y2 = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double x3 = Double.parseDouble(st.nextToken());
		double y3 = Double.parseDouble(st.nextToken());
		double x4 = Double.parseDouble(st.nextToken());
		double y4 = Double.parseDouble(st.nextToken());
		
		if (x1 == x2 && x3 == x4) {
			System.out.println(0);
			return;
		}
		
		double x5 = Math.min(x1, x2);
		double x6 = Math.max(x1, x2);
		double x7 = Math.min(x3, x4);
		double x8 = Math.max(x3, x4);
		double y5 = Math.min(y1, y2);
		double y6 = Math.max(y1, y2);
		double y7 = Math.min(y3, y4);
		double y8 = Math.max(y3, y4);
		
		double x, y, a, b, c, d;
		
		if (x5 == x6) {
			x = x5;
			c = (y7 - y8) / (x7 - x8);
			d = y7 - c * x7;
			y = c * x + d;
		}
		else if (x7 == x8) {
			x = x7;
			a = (y5 - y6) / (x5 - x6);
			b = y5 - a * x5;
			y = a * x + b;
		}
		else {
			a = (y1 - y2) / (x1 - x2);
			c = (y3 - y4) / (x3 - x4);
			if (a == c) {
				System.out.println(0);
				return;
			}
			b = y1 - a * x1;
			d = y3 - c * x3;
			
			x = (d - b) / (a - c);
			y = a * x + b;
		}
		
		if (x >= x5 && x <= x6 && y >= y5 && y <= y6) {
			if (x >= x7 && x <= x8 && y >= y7 && y <= y8) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	
}
