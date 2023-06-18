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
 * @FileName : Main_16401_과자나눠주기_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 16.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_16401_과자나눠주기_실2 {
	static int M, N;
	static int snack[];
	static long check=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st =new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());//조카 
		N =Integer.parseInt(st.nextToken());//과자의 수 
		snack = new int[N];
		st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			check+=snack[i];
		}
		if(check<M) {
			System.out.println(0);
			return;
		}
		int start= 1;
		int end =1000000000;
		int mid=0;
		int answer =0;
		while(start<=end) {
			mid = (start+end)/2;
			//System.out.println("과자가 "+mid+"일때 ");
			if(count(mid)>=M) {
				start=mid+1;
				answer = mid;
			}else {
				end=mid-1;
			}
		}
		System.out.println(answer);
	}
	public static int count(int len) {
		int cnt=0;
		for(int i=0;i<N;i++) {
			cnt+=snack[i]/len;
		}
		return cnt;
	}

}
