/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**

  * @FileName : Main_2252_줄세우기.java

  * @Project : NewAlgo

  * @Date : 2023. 4. 20. 

  * @작성자 : hseol

  * @변경이력 :

  * @프로그램 설명 :

  */
public class Main_2252_줄세우기_골3 {
static int N,M;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer>queue = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		int[] check = new int[N+1];
		for(int i=0;i<=N;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken()); 
			int back = Integer.parseInt(st.nextToken()); 
			arr[front].add(back);
			check[back]++;
		}
		//입력끝
		for(int i =1;i<=N;i++) {
			if(check[i]==0)queue.add(i);
		} //초기에 아무것도 없는 애들 넣어
		
		while(!queue.isEmpty()) {
			int front = queue.poll();
			sb.append(front).append(" ");
			for(int i=0;i<arr[front].size();i++) {
				int next = arr[front].get(i);
				check[next]--;
				if(check[next]==0) {
					queue.add(next);
				}
				
			}
		}
		System.out.println(sb);
		

	}

}
