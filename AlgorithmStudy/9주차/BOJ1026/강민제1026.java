public class Main1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		Integer[] arrB = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
			arrB[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int sum=0;
		for(int i:arrA) {
			sum += arrB[--N] * i;
		}
		System.out.println(sum);
	}
}
