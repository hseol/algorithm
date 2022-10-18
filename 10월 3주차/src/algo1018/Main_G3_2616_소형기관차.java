package algo1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//18808KB 164ms
public class Main_G3_2616_소형기관차 {
	public static void main(String[] args) throws Exception {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] passenger = new int[N+1];
		int[] sum = new int[N+1];
		for(int i=1; i<=N; i++) {
			passenger[i]=Integer.parseInt(st.nextToken());
			sum[i]=sum[i-1]+passenger[i];
		}
		int max = Integer.parseInt(br.readLine());
		
		//solution
		int[][] dp = new int[4][N+1];
		for(int i=1; i<=3; i++) {
			for(int j=i*max; j<=N; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-max]+sum[j]-sum[j-max]);
			}
		}
		
		//output
		System.out.println(dp[3][N]);
	}

}
