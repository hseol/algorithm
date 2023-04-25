/**
 * 
 */
package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_17182_우주탐사선_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 25.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_17182_우주탐사선_골3 {

	/**
	 * @param args
	 */
	static boolean visited[];
	static int N,map[][],result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		for (int k = 0; k < N; ++k) { // 경
			for (int i = 0; i < N; ++i) {// 출
				if (k == i)
					continue;
				for (int j = 0; j < N; ++j) {// 도
					if (j == k || j == i)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		visited = new boolean[N];
		visited[K]=true;
		permu(0,K,0);
//		for(int[] i :map) {
//			for(int j :i) {
//				System.out.print(j+" ");
//			}System.out.println();
//		}
		System.out.println(result);
		//System.out.println(map[0][N-1]);
	}
	public static void permu(int cnt,int start, int sum) {
		if(cnt==N-1) {
			result = Math.min(result, sum);
			return;
		}
		for(int i =0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				permu(cnt+1,i,sum+map[start][i]);
				visited[i] = false;
			}
		}
	}

}
