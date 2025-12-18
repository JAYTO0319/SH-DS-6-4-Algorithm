package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전체 배열 = 2^N * 2^N

// 가장 작은 네모(숫자 하나)를 '칸'이라고 정의
// n*n개의 같은 색상 칸들의 배열을 '부분배열'로 정의
// m*m개의 부분배열의 배열을 '집합배열'이라고 정의함.

// n = 2^l
// m = 2^(N-l)


// 구현 단계 고민
// 1. 부분배열의 좌우 반전, 상하 반전 구현
// 2. 부분배열의 시계 방향 90도, 반시계 방향 90도 회전 구현
// 3. 1,2,3,4번 연산을 m*m 집합배열에 어떻게 적용할 지.
// 4. 5,6,7,8번 연산에 대한 고민


// 인덱스 정의가 필요해보임.
// 부분배열(n*n) 내 한 칸의 인덱스를 (i,j)로 표현.  i: 0 ~ n-1 / j: 0 ~ n-1
// 집합배열(m*m) 내 부분배열의 인덱스를 (a,b)로 표현. a: 0 ~ m-1/ b: 0 ~ m-1

// 전체 배열에서 한 칸의 인덱스는? (x,y) 로 표현하겠음.
// 이때 x = a*n+i , y = b*n+j



public class BOJ20327 {
	
	public static int[][] arr;
	
	public static void swap(int i1, int j1, int i2,int j2) {
		int tmp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = tmp;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int twoN = (int)Math.pow(2, N);
		
		arr = new int[twoN][twoN];
		
		int arr2[][];
		
		for(int i = 0; i < twoN; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < twoN; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// x = a*n+i , y = b*n+j
		while(R-- > 0) {
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int n = (int)Math.pow(2, l);
			int m = (int)Math.pow(2, N - l);
			
			switch (k) {
				//각 부분배열 상하 반전
			    case 1:
			    	for(int a = 0; a < m; a++) {
			    		for(int b = 0; b < m; b++) {
			    			// i 와 n-1-i 교환
			    			for(int i = 0; i < n/2; i++){
			    				for(int j = 0; j < n; j++){
			    					swap(a*n + i, b*n + j, a*n + n-1-i, b*n + j);
						    	}
					    	}
			    			
				    	}
			    	}
			    	break;
			    //각 부분배열 좌우 반전
			    case 2:
			    	for(int a = 0; a < m; a++) {
			    		for(int b = 0; b < m; b++) {
			    			// j와 n-1-j 교환
			    			for(int i = 0; i < n; i++) {
			    				for(int j = 0; j < n/2; j++) {
			    					swap(a*n + i, b*n + j, a*n + i, b*n + n-1-j);
						    	}
					    	}
			    			
				    	}
			    	}
			    	break;
			    //각 부분배열 시계 방향 90도 회전
			    case 3:
			    	for(int a = 0; a < m; a++) {
			    		for(int b = 0; b < m; b++) {
			    			// (i,j) 이 (j,n-1-i) 로 감.
			    			// 새 배열 선언 안하고 회전하는 법 아시는 분 팁좀요
			    			arr2 = new int[n][n];

			    			for(int i = 0; i < n; i++){
			    				for(int j = 0; j < n; j++){
			    					arr2[j][n-1-i] = arr[a*n + i][b*n + j];
			    				}
			    			}
			    			
			    			for(int i = 0; i < n; i++){
			    				for(int j = 0; j < n; j++){
			    					arr[a*n + i][b*n + j] = arr2[i][j];
						    	}
					    	}
			    			
				    	}
			    	}
			    	break;
			    //각 부분배열 반시계 방향 90도 회전
			    case 4:
			    	for(int a = 0; a < m; a++) {
			    		for(int b = 0; b < m; b++) {
			    			// (i,j) 이 (n-1-j,i) 로 감.
			    			arr2 = new int[n][n];

			    			for(int i = 0; i < n; i++){
			    				for(int j = 0; j < n; j++){
			    					arr2[n-1-j][i] = arr[a*n + i][b*n + j];
			    				}
			    			}
			    			
			    			for(int i = 0; i < n; i++){
			    				for(int j = 0; j < n; j++){
			    					arr[a*n + i][b*n + j] = arr2[i][j];
						    	}
					    	}
			    			
				    	}
			    	}
			    	break;
			  //각 집합배열 상하 반전
			    case 5 :
			    	for(int i = 0; i < n; i++) {
			    		for(int j = 0; j < n; j++) {
			    			//a와 m-1-a 교환
			    			for(int a = 0; a < m/2; a++){
			    				for(int b = 0; b < m; b++){
			    					swap(a*n + i, b*n + j, (m-1-a)*n + i, b*n + j);
						    	}
					    	}
			    			
				    	}
			    	}
			    	break;
				//각 집합배열 좌우 반전
			    case 6 :
			    	for(int i = 0; i < n; i++) {
			    		for(int j = 0; j < n; j++) {
			    			//b와 m-1-b 교환
			    			for(int a = 0; a < m; a++) {
			    				for(int b = 0; b < m/2; b++) {
			    					swap(a*n + i, b*n + j, a*n + i, (m-1-b)*n + j);
						    	}
					    	}
			    			
				    	}
			    	}
			    	break;
			    //각 집합배열 시계 방향 90도 회전
			    case 7 :
			    	arr2 = new int[n*m][n*m];
	    			// (a,b) 이 (b,m-1-a) 로 감.
			    	for(int a = 0; a < m; a++) {
			    		for(int b = 0; b < m; b++) {
			    			for(int i = 0; i < n; i++){
			    				for(int j = 0; j < n; j++){
			    					arr2[b*n + i][(m-1-a)*n + j] = arr[a*n + i][b*n + j];
			    				}
			    			}
				    	}
			    	}
			    	for(int a = 0; a < m; a++) {
			    		for(int b = 0; b < m; b++) {
			    			for(int i = 0; i < n; i++){
			    				for(int j = 0; j < n; j++){
			    			    	arr[a*n + i][b*n + j] = arr2[a*n + i][b*n + j];
			    			    }
			    			}
				    	}
			    	}
			    	break;
			    //각 집합배열 반시계 방향 90도 회전
			    case 8:
			    	arr2 = new int[n*m][n*m];
	    			// (a,b) 이 (m-1-b,a) 로 감.
			    	for(int a = 0; a < m; a++) {
			    		for(int b = 0; b < m; b++) {
			    			for(int i = 0; i < n; i++){
			    				for(int j = 0; j < n; j++){
			    					arr2[(m-1-b)*n + i][a*n + j] = arr[a*n + i][b*n + j];
			    				}
			    			}
				    	}
			    	}
			    	for(int a = 0; a < m; a++) {
			    		for(int b = 0; b < m; b++) {
			    			for(int i = 0; i < n; i++){
			    				for(int j = 0; j < n; j++){
			    			    	arr[a*n + i][b*n + j] = arr2[a*n + i][b*n + j];
			    			    }
			    			}
				    	}
			    	}
			    	break;
			}
		};
			
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < twoN; i++) {
			for(int j = 0; j < twoN; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}


//코드 다 짜고 보니까 그냥 for 문 안에서 switch문 써도 됐을듯
