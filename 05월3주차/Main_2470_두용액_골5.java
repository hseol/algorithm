/**
 * 
 */
package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2470_두용액.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 20.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2470_두용액_골5 {
	static int N;
	static long number[],answer[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		number = new long[N];
		answer = new long[2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
//		for(long i :number) {
//			System.out.print(i+" ");
//		}System.out.println();
		
		
		int start =0;
		int end = N-1;
		long result = Integer.MAX_VALUE;
		while(start<end) {
			long mid = number[start]+number[end];
			//System.out.println(mid);
			if(Math.abs(mid)<result) {
				result = Math.abs(mid);
				answer[0] = number[start];
				answer[1] = number[end];
			}
			if(mid<=0) {
				start++;
			}else {
				end--;
			}
			
		}
		System.out.println(answer[0]+" "+answer[1]);
	}

}
