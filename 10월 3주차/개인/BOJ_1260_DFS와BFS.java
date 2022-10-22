package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	static int N,M,V; // 정점, 간선, 시작정점
	static int adjMatrix[][]; // 인접리스트

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer( br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];

		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adjMatrix[start][end] = adjMatrix[end][start] =1;
		}
		
		DFS(adjMatrix,new boolean[N+1],V);
		sb.append("\n");
		BFS(adjMatrix,V);
		
		System.out.println(sb);
		

		
	}
	
	public static void DFS(int [][] adjMatrix, boolean [] visited, int current) 
	{
		visited[current] = true;
		sb.append(current).append(" ");
		
		for(int i=1; i<N+1;i++) 
		{
			if(!visited[i] && adjMatrix[current][i]!=0) 
			{
				DFS(adjMatrix,visited,i);
			}
		}
	}
	public static void BFS(int [][] adjMatrix,int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		visited[start] =true;
		
		while(!queue.isEmpty()) 
		{
			int current =queue.poll();
			
			sb.append(current).append(" ");
			for(int i=1;i<N+1;i++) 
			{
				if(!visited[i]&&adjMatrix[current][i]!=0) 
				{
					
					visited[i]=true;
					queue.offer(i);
				}
			}
		}
	}
	
	

}
