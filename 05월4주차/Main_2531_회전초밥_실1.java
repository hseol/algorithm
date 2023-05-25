/**
 * 
 */
package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2531_회전초밥_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 26.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2531_회전초밥_실1 {
	static int N, d, k, c;
	static int sushi[],check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer =0;
		int count=0;
		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi =new int[N];
		check = new int[d+1];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for(int i =0;i<k;i++) {
			if(check[sushi[i]]==0) {
				count++;
			}
			check[sushi[i]]++;
		}
		if(check[c]==0) {
			count++;
		}
		check[c]++;
		answer = Math.max(answer, count);
		int start =0;
		int end = k;
		while(true) {
//			set.add(c);
//			answer =Math.max(answer,set.size());
//			set.add(sushi[end]);
//			set.remove(sushi[start]);
			check[sushi[end]]++;
			if(check[sushi[end]]==1)count++;
			check[sushi[start]]--;
			if(check[sushi[start]]==0)count--;
			answer= Math.max(answer, count);
			start = (start+1)%N;
			end= (end+1)%N;
			
			if(start==0)break;

		}
		System.out.println(answer);
	}

}
