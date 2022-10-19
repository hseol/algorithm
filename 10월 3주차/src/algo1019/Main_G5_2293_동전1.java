package algo1019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11588KB 88ms
public class Main_G5_2293_동전1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[k+1];
		dp[0]=1;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j>=coin[i]) dp[j]+=dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[k]);
	}

}
