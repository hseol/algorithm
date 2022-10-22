package my;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedReader;

public class BOJ_3182_S3_한동이는_공부가_하기_싫어 {

	static int N, answer;
	static int[] matrix;
	static int max = 0;
	static int result ;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		matrix = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			matrix[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i < N + 1; i++) {
			result=DFS(i, new boolean[N + 1], 0);
			if(result>max) 
			{
				answer =i;
				max=result;
			}else if(result == max) 
			{	
				if(answer >i)
					answer=i;
			}
		}

		System.out.println(answer);
		

	}

	static int DFS(int start, boolean[] visited, int len) {
		visited[start] = true;
		len++;

		if (!visited[matrix[start]]) {
			len=DFS(matrix[start], visited, len);

		}
		
		return len;
	}
}
