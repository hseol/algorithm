package algo1027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//11588KB 80ms
public class Main_G5_1038_감소하는수 {
	
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list.add(0);
		
		for(int i=1; i<=9; i++) {
			dfs(i, 0, 0);
		}
		
		int N = Integer.parseInt(br.readLine());
		if(N==list.size()) {
			System.out.println("9876543210");
			return ;
		} 
		try {
			System.out.println(list.get(N));
		} catch(IndexOutOfBoundsException e) {
			System.out.println(-1);
		}
	}
	
	public static void dfs(int goal, int idx, int cur) {
		if(goal == idx) {
			list.add(cur);
			return ;
		}
		
		int limit = cur==0? 9 : (int)(cur%10-1);
		for(int i=cur==0?1:0; i<=limit; i++) {
			int tmp = cur*10 + i;
			dfs(goal, idx+1, tmp);
		}
	}
}
