/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_16165_걸그룹마스터준석이_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 4.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_16165_걸그룹마스터준석이_실3 {
	static int N, M;
	static Map<String, Integer> groups;
	static Map<String, String> members;
	static List<String>[] list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		groups = new HashMap<>();
		members = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			String group = br.readLine();
			groups.put(group,i);
			int number = Integer.parseInt(br.readLine());

			for (int j = 0; j < number; j++) {
				String member = br.readLine();
				members.put(member, group);
				list[i].add(member);
			}

		}
		while (M-- > 0) {// 문제시작
			String problem = br.readLine();
			int type = Integer.parseInt(br.readLine());
			solve(problem,type);
		}
		System.out.println(sb);
	}

	public static void solve(String problem, int type) {
		if (type == 1) {// 속한 그룹 찾기
			sb.append(members.get(problem)).append("\n");
		}
		if (type == 0) {// 그룹내 멤버 말하기
			Collections.sort(list[groups.get(problem)]);
			for(String i:list[groups.get(problem)]) {
				sb.append(i).append("\n");
			}
		}
	}

}
