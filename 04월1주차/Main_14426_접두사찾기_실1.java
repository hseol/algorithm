/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_14426_접두사찾기_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 6.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_14426_접두사찾기_실1 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashSet<String>[] has = new HashSet[501];
		for(int i=1;i<=500;i++) {
			has[i] = new HashSet<>();
		}
		while(N-- >0) {
			String str = br.readLine();	
			StringBuilder sb = new StringBuilder();
			for(int i =0;i<str.length();i++) {
				sb.append(str.charAt(i));
				has[sb.length()].add(sb.toString()); //한글자씩 덧붙이면서 해시셋에 넣는중
			}
		}
		int count=0;
		while(M-- >0) {
			String str = br.readLine();
			if(has[str.length()].contains(str)) {
				count++;
			}
			
		}
		System.out.println(count);
	}

}
