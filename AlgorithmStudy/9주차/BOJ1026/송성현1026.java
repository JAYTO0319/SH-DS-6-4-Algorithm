
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		
		//B에 있는 수는 재배열하면 안 된다.  중요
		int[] B = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		int i=0;
		while(st1.hasMoreTokens()) {
			A[i++] = Integer.parseInt(st1.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int j=0;
		while(st2.hasMoreTokens()) {
			B[j++] = Integer.parseInt(st2.nextToken());
		}
		
		//오름차순 정렬
		Arrays.sort(A);
		
		//최종값
		int min_num = 0;
		
		for(int k=0; k<N; k++) {
			//최종 순서
			int count = 0;
			//B배열에서 하나씩 비교하면 큰 값의 순서가 나온다.
			for(int t=0; t<N; t++) {
				//현재 대상보다 크다면 count++증가
				if(B[k]<B[t]) {
					count++;
				}
				//만약 현재 대상과 같은 값이 있다면 현재값의 count++ 증가
				if(B[k]==B[t] && k<t) {
					count++;
				}
			}
			//B의 현재 값과 최종 순서를 A에 대입하여 곱하기
			min_num += B[k]*A[count];
			
		}
		System.out.println(min_num);
	}
}
