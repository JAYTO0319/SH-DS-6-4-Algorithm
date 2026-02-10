import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 김아현1251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine(); // mobitel
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 1; i < line.length() - 1; i++) {
			for (int j = i + 1; j < line.length(); j++) {
				String s1 = line.substring(0, i);
				String s2 = line.substring(i, j);
				String s3 = line.substring(j);

				list.add(reverse(s1) + reverse(s2) + reverse(s3));
			}
		}
		Collections.sort(list); // 사전순 정렬(오름차순)
		System.out.println(list.get(0)); // bometil
	}

	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}
