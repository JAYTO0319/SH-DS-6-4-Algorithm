import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String iniWord = br.readLine();
		int idx = 0;
		String num = "0";
		while (idx < iniWord.length()) {
			//num은 현재 숫자. num의 각 자릿수를 돌며 charAt(idx)가 자릿수와 같으면 idx 증가
			//다르면 다음 자릿수로 넘어가고 모든 자릿수 돌았으면 num이 1증가
			num = String.valueOf(Integer.parseInt(num) + 1);
			for (int i = 0; i < num.length(); i++) {
				if (num.charAt(i) == iniWord.charAt(idx)) {
					idx++;
					if (idx >= iniWord.length()) {
						System.out.println(num);
						return;
					}
				}
			}
		}
		System.out.println(num);
	}

}
