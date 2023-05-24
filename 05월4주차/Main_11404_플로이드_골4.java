/**
 * 
 */
package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_11404_플로이드_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 23.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_11404_플로이드_골4 {
	static int N, M;
	static long map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new long[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			if(map[start][end]>cost)
			map[start][end]=cost;
		}
		for(int k=0;k<N;++k) {
			for(int i=0;i<N;++i) {
				if(k==i)continue;
				for(int j =0;j<N;++j) {
					if(k==j||i==j)continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]= map[i][k]+map[k][j];
					}
				}
			}
		}
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(map[i][j]==Integer.MAX_VALUE) {
					map[i][j]=0;
				}
				sb.append(map[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}

}
