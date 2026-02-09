import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int l = word.length();
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < l; i++) {
			answer.append("z");
		}
		StringBuilder first = new StringBuilder();
		StringBuilder second = new StringBuilder();
		StringBuilder third = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		for (int i = 1; i < l - 1; i++) {
			for (int j = i + 1; j < l; j++) {
				first.setLength(0);
				second.setLength(0);
				third.setLength(0);
				tmp.setLength(0);
				first.append(word.substring(0,i)).reverse();
				second.append(word.substring(i,j)).reverse();
				third.append(word.substring(j,l)).reverse();
				tmp.append(first).append(second).append(third);
				if (tmp.compareTo(answer) < 0) {
					answer.setLength(0);
					answer.append(tmp);
				}
			}
		}
		System.out.println(answer);
	}

}
