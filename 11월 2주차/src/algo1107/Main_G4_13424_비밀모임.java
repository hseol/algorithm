package algo1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//23776KB 368ms
public class Main_G4_13424_비밀모임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j]= (i!=j)? 1000000000 : 0;
				}
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				dist[a][b]=c;
				dist[b][a]=c;
			}
			
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(i==j) continue;
						dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			int K = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int min = 1000000000;
			int idx = -1;
			for(int i=1; i<=N; i++) {
				int sum=0;
				for(int j=0; j<K; j++) {
					sum+=dist[arr[j]][i];
				}
				if(sum<min) {
					idx=i;
					min=sum;
				}
			}
			System.out.println(idx);
		}
	}
}
