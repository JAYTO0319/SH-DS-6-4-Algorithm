public class Main2304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new TreeMap<>();
		int[] arrX = new int[N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.put(x, y);
			arrX[i] = x;
		}
		Arrays.sort(arrX);
		int i=1;
		int lX = arrX[0]; int lY = map.get(lX);
		int rX = arrX[--N]; int rY = map.get(rX);
		int sum = 0;
		while(lY != rY) {
			if(lY < map.get(arrX[i])) {
				sum += (arrX[i]-lX) * lY;
				lX = arrX[i];
				lY = map.get(lX);
			}
			if(rY < map.get(arrX[N])) {
				sum += (rX - arrX[N]) * rY;
				rX = arrX[N];
				rY = map.get(rX);
			}
			i++;
			N--;
		}
		System.out.println(sum+((rX-lX+1)*lY));
	}
}
