/**
 * 
 */
package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_13186_내일로여행_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 24.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_13186_내일로여행_골3 {
	static int N, M, journey[];
	static int ticket;
	static double ticketco[][], co[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ticketco = new double[N][N];
		co = new double[N][N];
		//lastarr = new double[N][N][2];
		ticket = Integer.parseInt(st.nextToken());
		String[] cities = br.readLine().split(" ");
		int index = 0;
		for (String s : cities) {
			if (map.containsKey(s))
				continue;
			map.put(s, index);
			index++;
		} // 도시마다 번호 부여

		M = Integer.parseInt(br.readLine()); // 들러야할 도시의 개수
		journey = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			journey[i] = map.get(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(ticketco[i], Integer.MAX_VALUE);
			Arrays.fill(co[i], Integer.MAX_VALUE);
		}
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cate = st.nextToken();
			int start = map.get(st.nextToken());
			int end = map.get(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			co[start][end] = Math.min(co[start][end], cost);
			co[end][start] = co[start][end];
			
			ticketco[start][end] = Math.min(ticketco[start][end], calcul(cate, cost));
			ticketco[end][start] = ticketco[start][end];
		}
		wa(co);
		wa(ticketco);

		double result1 = 0;
		double result2 = 0;
		for (int i = 0; i < M - 1; i++) {
			result1 += co[journey[i]][journey[i + 1]];
			result2 += ticketco[journey[i]][journey[i + 1]];
		}
		if ((result2 + ticket) < result1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static double calcul(String cate, double cost) {
		double percent = 1;
		if (cate.equals("S-Train") || cate.equals("V-train")) {
			percent = 0.5;
		} else if (cate.equals("Mugunghwa") || cate.equals("ITX-Saemaeul") || cate.equals("ITX-Cheongchun")) {
			percent = 0;
		}
		return cost * percent;

	}
	public static void wa(double[][]arr) {
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				if (k == i)
					continue;
				for (int j = 0; j < N; ++j) {
					if (k == j || i == j)
						continue;
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
	}
}
