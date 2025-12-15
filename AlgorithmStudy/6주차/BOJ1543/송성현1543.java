package selfstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1543 {

	public static void main(String[] args) throws IOException {
		//첫째 줄에 문서가 주어진다. 문서의 길이는 최대 2500이다. 둘째 줄에 검색하고 싶은 단어가 주어진다.
		//중복되어 세는 것은 빼고 세야 한다
		
		//검색하고 싶은 단어의 길이
		//문자 1개씩 체크하면서 검색하고 싶은 단어 체크
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//주어진 문서 = document
		//찾으려는 단어 = word
		String document = br.readLine();
		String word = br.readLine();
		
		//반복문을 돌리는데 주어진 문서 문자열을 word의 길미만큼 잘라서 비교
		//세준이의 이 함수는 이 단어를 0번부터 찾을 수 있고, 2번부터도 찾을 수 있다 현재코드에서 이걸 구현해야함.
		int total_count = 0;
		for(int i=0; i<document.length(); i++) {
			if(i+word.length() < document.length()) {
				document.substring(i, i+word.length()).equals(word);
				i += word.length()-1;
				total_count += 1;
			} else {
				break;
			}
		}
		System.out.println(total_count);
	}

}
