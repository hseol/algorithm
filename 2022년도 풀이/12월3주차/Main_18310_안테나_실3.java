package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18310_안테나_실3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int ans =  2147483647;
		int max; 
		int result=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			max=0;
			for(int j=0;j<N;j++) {
				max+= Math.abs(arr[i]-arr[j]);
			}
			if(ans>max) {
				ans=max;
				result=arr[i];
			}
		}
		System.out.println(result);
		
	}

}
