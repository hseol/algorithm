/**
 * 
 */
package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_16947_서울지하철2호선_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 5.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_16947_서울지하철2호선_골3 {
	static int N, distance[];
	static boolean isCycle, visited[];
	static ArrayList<Integer>[] map;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		distance = new int[N + 1];
		Arrays.fill(distance, -1);
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}//입력 끝 
		Cycle(0,1);
		bfs();
		for (int i = 1; i <= N; i++) {
			System.out.print(distance[i]+" ");
		}
	}// 메인

	public static void Cycle(int pre, int cur) {
		visited[cur] = true;
		for (int next : map[cur]) { //cur에 인접한 역들 탐색
			if (visited[next] && next != pre) { // 전 방문지 아닌데 이미 방문했다. 사이클이다
				isCycle = true;
				distance[next]=0;
				queue.add(next);
				break;
			} else if (!visited[next]) { // 방문하지 않았음
				Cycle(cur, next);
				if (isCycle) { // 사이클이 형성되서 브레이크돼서 나왔음 
					//System.out.println(next);
					if (distance[next] == 0) {
						isCycle = false; // 다시 초기화?
					} else {// 방문안했던 애면
						distance[next] = 0;// 순환선 만났으니까 거리 0
						queue.add(next);
					}
					return;
				}
			}
		}
	}

	public static void bfs() {
		int cnt = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int sta = queue.poll();
				for (int j : map[sta]) {
					if (distance[j] != -1)
						continue;
					distance[j] = cnt;
					queue.add(j);
				}
			}
			cnt++;
		}
	}

}
