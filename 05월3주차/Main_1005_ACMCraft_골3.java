/**
 * 
 */
package Topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1005_ACMCraft_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 16.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1005_ACMCraft_골3 {
	static int T, N, K, time[], indegree[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N + 1];
			indegree = new int[N + 1];// 차수
			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			} // 초기화

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list.get(start).add(end);
				indegree[end]++;
			}
			int w = Integer.parseInt(br.readLine());
			// 입력 끝
			topol(list, w);

		}
		System.out.println(sb);

	}

	public static void topol(List<List<Integer>> list, int w) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			result[i] = time[i];

			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (Integer i : list.get(node)) { // 노드에서 향하고 있는 노드들
				result[i] = Math.max(result[i], result[node] + time[i]);
				indegree[i]--;

				if (indegree[i] == 0) {
					queue.offer(i);
				}
			}

		}
		sb.append(result[w]).append("\n");
	}
}
