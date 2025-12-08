
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class bj1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫째 줄에 단어의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<String>();
		
		//hashset에 중복없이 단어 저장
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		//저장된 것을 array로 저장
		String[] arr = new String[set.size()];
		int i=0;
		for(String data1:set) {
			arr[i] = data1;
			i++;
		}

		
		//1.길이가 짧은 것부터
		//2.길이가 같으면 사전 순으로

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String d1, String d2) {
				if(d1.length() == d2.length()) {
					//return d1.charAt(0) - d2.charAt(0);
					
					//문자 전체를 순서대로 비교
					//첫 번째 글자 비교
					// 같으면 두 번째 글자비교...
					return d1.compareTo(d2);
				}else {
					return d1.length() - d2.length();
				}
			}
		});
		
		StringBuffer sb = new StringBuffer();
		
		for(String data:arr) {
			sb.append(data+"\n");
		}
		
		System.out.println(sb);
		
	}
}
