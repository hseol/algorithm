
package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_17070_파이프옮기기1_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 7.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_17070_파이프옮기기1_골5_DFS {
	static int[] dr = { 1, 0, 1 };// 세로, 가로, 대각선
	static int[] dc = { 0, 1, 1 };
	static int N, map[][];
	static int dp[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1][3];
		dp[1][2][1]=1;
		//0 세로, 1가로 , 2대각선
			for(int i =1;i<=N;i++) {
				for(int j=2;j<=N;j++) {
					if(map[i][j]==0) {
						//세로
						dp[i][j][0]+=dp[i-1][j][0]+dp[i-1][j][2];
						//가로
						dp[i][j][1]+=dp[i][j-1][1]+dp[i][j-1][2];
						//대각선
						if(map[i-1][j]+map[i][j-1]==0)dp[i][j][2]+=dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
					}
				}
			}
			System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
	}
}
