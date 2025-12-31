public class Main2303 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max=0, maxN=0, i=0;
		for(i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				for(int k=j+1;k<4;k++) {
					for(int l=k+1;l<5;l++) {
						int sum = 0;
						sum += arr[i][j] + arr[i][k] + arr[i][l];
						if(sum%10 >= max) {
							max = sum%10;
							maxN = i;
						}
					}
				}
			}
		}
		System.out.println(maxN+1);
	}
}
