package selfstudy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BJ2606_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//컴퓨터의 수
		int com_count = Integer.parseInt(br.readLine());
		
		//네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
		int network_con = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[network_con][2];
		for(int i=0; i<network_con;i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			arr[i][0] = a;
			arr[i][1] = b; 
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		
		//System.out.println(stack);
		while(!stack.isEmpty()) {
			int data = stack.pop();
			for(int j=0; j<network_con; j++) {
        //!set.contains(arr[j][1])를 무조건 넣어야 함.
				if(arr[j][0]==data && !set.contains(arr[j][1])) {
					stack.add(arr[j][1]);
					set.add(arr[j][1]);
					//System.out.println("stack" + stack);
					//System.out.println("set" + set);
					//System.out.println();
					
				}else if(arr[j][1]==data && !set.contains(arr[j][0])){
					stack.add(arr[j][0]);
					set.add(arr[j][0]);
					//System.out.println("stack" + stack);
					//System.out.println("set" + set);
					//System.out.println();
				}
			}
		}
		System.out.println(set.size()-1);
		
		
		
		/*
		 * 실패한 for문
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		for(int i=0; i<network_con;i++) {
			for(int j=0; j<network_con; j++) {
				if((arr[j][0]==j+1 || arr[j][1]==j+1) && (set.contains(arr[j][0])||set.contains(arr[j][1]))) {
					set.add(arr[j][0]);
					set.add(arr[j][1]);
				}
			}
		}
		
		if(set.size()==1) {
			System.out.println(0);
		}else {
			System.out.println(set.size()-1);
		}
		*/
	}
}
