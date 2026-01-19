public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, String> map = new TreeMap<>();
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String enter = st.nextToken();
			map.put(name, enter);
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder();
		for(String s:list) {
			if(map.get(s).equals("enter")) sb.append(s+"\n");
		}
		System.out.println(sb);
	}
}
