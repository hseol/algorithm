package algo1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14680KB 228ms
public class Main_G3_11049_행렬곱셈순서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][2];
		int[][] dp = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[i][0]=r;
			map[i][1]=c;
		}
		
		for(int i=0; i<N-1; i++) {
			dp[i][i+1] = map[i][0] * map[i][1] * map[i+1][1];
		}
		
		for(int l=2; l<N; l++) {
			for(int i=0; i+l<N; i++) {
				int j = i+l;
				dp[i][j]=Integer.MAX_VALUE;
				
				for(int k=i; k<j; k++) {
					dp[i][j] = Math.min(dp[i][j], 
							dp[i][k]+dp[k+1][j]+(map[i][0]*map[k][1]*map[j][1]));
				}
			}
		}
		System.out.println(dp[0][N-1]);
	}

}
