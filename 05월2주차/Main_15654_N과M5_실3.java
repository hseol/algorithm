/**
 * 
 */
package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_15654_N과M5_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 13.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_15654_N과M5_실3 {
	static int N, M, number[], arr[];
	static boolean isSelected[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb =new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		isSelected = new boolean [N];
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
		Permu(0);
		System.out.println(sb);
	}

	public static void Permu(int cnt) {
		if (cnt == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i])continue;
			
			arr[cnt] = number[i];
			isSelected[i] = true;
			Permu(cnt+1);
			isSelected[i] = false;
		}

	}
}
