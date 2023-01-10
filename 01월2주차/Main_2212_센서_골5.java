package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2212_센서_골5 {
	static int N, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N= Integer.parseInt(br.readLine());
		K= Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int [] arr = new int[N];
		Integer [] distance = new Integer [N-1];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(K>=N) {
			System.out.println(0);
			return;
		}

		Arrays.sort(arr);
		for(int i =1;i<N;i++) {
			distance[i-1]=arr[i]-arr[i-1];
		}
		Arrays.sort(distance);
		int end = N-K;
		int answer=0;
		for(int i=0;i<end;i++) {
			answer+=distance[i];
		}
		System.out.println(answer);
	}

}

/*기지국문제인것처럼 앞뒤로 영역 펼치는건줄 알고 삽질한 문제.. 
 * 문제 이해가 안가서 결국 문제를 찾아보다가 결정적인 힌트를 얻어버린 문제임.. 
 * */
 