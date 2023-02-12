/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @FileName : Main_4358_생태학.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 12.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_4358_생태학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> trees = new HashMap<>();
		int all = 0;
		String str = br.readLine();

		while (true) { // 이거 기억하고 있자
			trees.put(str, trees.getOrDefault(str, 0) + 1); // 헉 신기하다
			all++;// 총 개수세기
			str = br.readLine();
			if(str==null||str.length()==0)break;
		}

		Object[] keys = trees.keySet().toArray();
		Arrays.sort(keys);// 이러면 오름차순
		StringBuilder sb = new StringBuilder();

		for (Object o : keys) {
			String keystr = (String) o;
			int count = trees.get(keystr);
			double percent = (double) (count * 100) / all;
			sb.append(keystr).append(" ").append(String.format("%.4f", percent)).append("\n");
		}
		System.out.println(sb.toString());

	}

}
