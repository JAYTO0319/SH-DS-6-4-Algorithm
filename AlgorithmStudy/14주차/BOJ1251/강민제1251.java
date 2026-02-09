public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Set<String> set = new TreeSet<>();
		for(int i=1;i<str.length()-1;i++) {
			for(int j=i+1;j<str.length();j++) {
				StringBuilder str1 = new StringBuilder();
				StringBuilder str2 = new StringBuilder();
				StringBuilder str3 = new StringBuilder();
				str1.append(str.substring(0, i));
				str2.append(str.substring(i,j));
				str3.append(str.substring(j,str.length()));
				set.add(str1.reverse() + "" + str2.reverse() + str3.reverse());
			}
		}
		System.out.println(new ArrayList(set).get(0));
	}
}
