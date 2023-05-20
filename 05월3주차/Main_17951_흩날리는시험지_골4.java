/**
 * 
 */
package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_17951_흩날리는시험지_골4.java
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
public class Main_17951_흩날리는시험지_골4 {
	static int N, K, exam[];
	static long max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		exam = new int[N];
		for (int i = 0; i < N; i++) {
			exam[i] = Integer.parseInt(st.nextToken());
			max += exam[i];
		}
		long start = 0;
		long end = max;
		int group = 0;
		while (start <= end) {
			long mid = (start + end) / 2;
			// System.out.println("mid"+mid);
			long result = 0;
			group=0;
			for (int i = 0; i < N; i++) {
				result+=exam[i];
				if (result >= mid) {
					 //System.out.println("result :"+result);
					result = 0;
					group++;
				}
			}
			if(group>=K) {
				start= mid+1;
			}else {
				end = mid-1;
			}
		}
		System.out.println(end);

	}

}
