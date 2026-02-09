public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
		arr[1] = arr[2] = arr[3] = 1;
		for(int i=4;i<arr.length;i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			sb.append(arr[Integer.parseInt(br.readLine())]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
