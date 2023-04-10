/**
 * 
 */
package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**

  * @FileName : Main_1012_유기농배추_실2.java

  * @Project : NewAlgo

  * @Date : 2023. 4. 10. 

  * @작성자 : hseol

  * @변경이력 :

  * @프로그램 설명 :

  */
public class Main_1012_유기농배추_실2 {
	static int T,N,M,K,map[][],answer=0;
	static boolean check[][];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
			st =new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			check = new boolean[N][M];
			for(int i =0;i<K;i++) {
				st =new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c]=1;
			}//입력끝 
			
			for(int i =0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1 && !check[i][j]) {
						answer++;
						BFS(i,j);
					}
				}
			}
			sb.append(answer).append("\n");
			answer =0;
		}
		System.out.println(sb.toString());
	}
	public static void BFS(int r, int c) {
		Queue<int[]>queue = new LinkedList<>();
		int [] dr = {-1,1,0,0};
		int [] dc = {0,0,-1,1};
		check[r][c] = true;
		queue.offer(new int[] {r,c});
		while(!queue.isEmpty()) {
			int[] loca = queue.poll();
			for(int d=0;d<4;d++) {
				int nr =loca[0]+dr[d];
				int nc = loca[1]+dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M||map[nr][nc]==0||check[nr][nc])continue;
				check[nr][nc] = true;
				queue.offer(new int[] {nr,nc});
				
			}
			
		}
		
		
	}

}
