import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j=0;
				while(st.hasMoreTokens()) {
					arr[i][j++] = Integer.parseInt(st.nextToken());
				}
		}
		
		//번호가 가장 큰 사람
		int num = 0;
		//최종 최대값
		int now_max = 0;
		
		
		/*
		가능한 모든 경우의 수 비교
		012
		013
		014
		023
		024
		034

		123
		124
		134

		234
		
		각 배열의 %10의 모든 경우를 result로 하나씩 저장 후 Math.max를 사용하여 최대값 구하기
		now_max라는 변수에 지금까지 계산한 최대값만 저장 후 result와 비교
		
		*/
		
		for(int k=0; k<arr.length;k++) {
			int result = 0;
			int[] data = arr[k];
			for(int i=0; i<3; i++) {
				for(int j=i+1; j<=3;j++) {
					for(int h=j+1; h<5; h++) {
						if(h>4) {
							continue;
						}
						
						result = Math.max(result, (data[i]+data[j]+data[h])%10);
						//System.out.println("["+ i + "]" + "["+ (j) + "]" +"["+ h + "]");
						//System.out.println(k + "일의 자리수" + (data[i]+data[j]+data[h])%10);
						//System.out.println("현재의 result : " + result);
					}
				}
			}
			//System.out.println();
			
			//현재까지의 최대값을 now_max
			//이번 배열에서의 최대값 result
			//now_max와 result를 비교하여 result가 크다면 사람의 번호 증가, now_max에 result값 넣기
			if(now_max <= result) {
				num = k+1;
				now_max = result;
			}
		}
		
		System.out.println(num);
		
	}
}
