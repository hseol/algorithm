/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_9375_패션왕신해빈_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 7.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_9375_패션왕신해빈_실3 {
	static int N;
	static Map<String,Integer>map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			map= new HashMap<>(); 
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String cate = st.nextToken();
				if(map.containsKey(cate)) {
					map.put(cate,map.get(cate)+1);
				}else {
					map.put(cate, 1);
				}

			} // 입력 끝
			
				// 조합함수
			sb.append(Calcul()).append("\n");
		}
		System.out.println(sb);
	}

	public static int Calcul() {
		int result = 1;
		for(int count : map.values()) {
			result*=(count+1);
		}
		return result-=1;

	}



}
