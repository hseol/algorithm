/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_17219_비밀번호찾기_실4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 7.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_17219_비밀번호찾기_실4 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<String, String> memo = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			memo.put(st.nextToken(), st.nextToken());
		}
		for(int i=0;i<M;i++) {
			bw.write(memo.get(br.readLine()));
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}

}
