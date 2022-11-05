package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_G1_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;

		Stack<int[]> stack = new Stack<int[]>();

		int N = Integer.parseInt(br.readLine());
		int buildings;
		
		st =new StringTokenizer(br.readLine());

		for(int i=1; i<=N;i++) 
		{
			buildings =Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) 
			{
				if(stack.peek()[1]>buildings) 
				{
					sb.append(stack.peek()[0]+" ");
					stack.push(new int[] {i,buildings});
					break;
				}
				else if(stack.peek()[1]<buildings) 
				{
					stack.pop();
					continue;
				}
			}
			if(stack.isEmpty()) 
			{
				stack.push(new int[] {i,buildings});
				sb.append(0+" ");
			}
		}
		
		System.out.println(sb);
	}

}
