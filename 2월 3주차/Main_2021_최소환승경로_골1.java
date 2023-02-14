/**
 * 
 */
package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2021_최소환승경로_골1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 15.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 : 5214 환승이랑 거의 같은 문제
 * 
 */
public class Main_2021_최소환승경로_골1 {
	static int N, L;
	static ArrayList<ArrayList<Integer>> stations, line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		stations = new ArrayList<>();
		line = new ArrayList<>();

		for (int i = 0; i <= N; ++i)
			stations.add(new ArrayList<Integer>());
		for (int i = 0; i <= L; ++i)
			line.add(new ArrayList<Integer>());
		for (int i = 1; i <= L; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			while (tmp != -1) {
				line.get(i).add(tmp);
				stations.get(tmp).add(i);
				tmp = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		System.out.println(BFS(start, end));
	}

	public static int BFS(int start, int end) {
		boolean[] visitS = new boolean[N + 1];
		boolean[] visitL = new boolean[L + 1];
		Queue<int[]> queue = new LinkedList<>();
		visitS[start] = true;
		for (int i : stations.get(start)) {
			visitL[i] = true;
			queue.offer(new int[] { i, 0 }); // 지하철 호선 넣은거임
		}
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			for (int lo : line.get(node[0])) { // 그 호선에 있는 역들을 순회해
				if (lo == end) {
					return node[1];
				}
				if (visitS[lo])
					continue;
				visitS[lo] = true;
				for (int li : stations.get(lo)) { // 역을 돌면서 그 역이 속한 호선도 체크
					if (visitL[li])
						continue;
					visitL[li] = true;
					queue.offer(new int[] { li, node[1] + 1 });
				}
			}
		}
		return -1;
	}
}
