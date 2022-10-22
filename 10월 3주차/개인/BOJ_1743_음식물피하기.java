package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ_1743_음식물피하기 {

	static int N,M,K ;// 세로, 가로, 음쓰수
	static boolean matrix [][];
	static boolean visited [][] ;
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	
	static int max =0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		matrix = new boolean [N+1][M+1];
		visited= new boolean [N+1][M+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			matrix[x][y] = true;
		}
		
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < M+1; c++) {
				if(matrix[r][c]&& !visited[r][c]) 
				{
					BFS(r,c);
				}
			}
		}
		
		System.out.println(max);
		
	}

	public static void BFS(int x,int y) 
	{
		Queue<int []> queue = new LinkedList<int []>();
		int result =1;
		
		queue.offer(new int [] {x,y});
		visited[x][y] = true;
		while(!queue.isEmpty()) 
		{
			
			int [] point = queue.poll();
			
			int X = point[0];
			int Y = point[1];
			
			
			for (int d = 0; d < 4; d++) {
				int nx = X+ dx[d];
				int ny = Y+ dy[d];
				
				if(!(nx>=0&&nx<N+1)||!(ny>=0&&ny<M+1))
					continue;
				if(visited[nx][ny])
					continue;
				
				if(!matrix[nx][ny])
					continue;
				
				
				
				result++;
				visited[nx][ny]=true;
				queue.offer(new int[] {nx,ny});
				
			}
		}
		max = Integer.max(max, result);
		
	}
}
