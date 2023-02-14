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
 * @FileName : Main_5214_환승_골2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 15.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_5214_환승_골2 {

	static int N, K, M;
	static ArrayList<Integer>[] stations, hypertubes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		stations = new ArrayList[N + 1];
		hypertubes = new ArrayList[M + 1];
		for (int i = 0; i <= M; ++i)
			hypertubes[i] = new ArrayList<>();
		for (int i = 0; i <= N; ++i)
			stations[i] = new ArrayList<>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				int station = Integer.parseInt(st.nextToken());
				hypertubes[i].add(station);
				stations[station].add(i);
			}
		}
		if (N == 1) { // 찾는 역이 1이면 1출력하고 끝내기
			System.out.println(1);
			return;

		}
		System.out.println(BFS());

	}

	public static int BFS() {
		boolean[] visitS = new boolean[N + 1];
		boolean[] visitH = new boolean[M + 1];
		Queue<int[]> queue = new LinkedList<>();
		visitS[1] = true;
		for (int i : stations[1]) {
			visitH[i] = true;
			queue.offer(new int[] { i, 1 }); // 초기역이 속하는 하이퍼튜브를 체크하면서 큐에 넣는다
		}
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			System.out.println(node[0]+"번 하이퍼튜브 체크 "+node[1]+"번 움직였음");
			for (int v : hypertubes[node[0]]) { // 큐에 넣은 하이퍼튜브를 돌면서 그 역이 있는지 확인
				// v 는 하이퍼튜브 내의 역들을 순회
				if (v == N) {// 목적지를 찾았는가?
					return node[1] + 1;
				}
				if (visitS[v])
					continue;
				visitS[v] = true;
				for (int rv : stations[v]) {// 반대로 하이퍼튜브내의 역이 속해있는 하이퍼튜브를 다시 체크
					if (visitH[rv])
						continue;
					visitH[rv] = true;
					queue.offer(new int[] { rv, node[1] + 1 });

				}
			}
		} // 그 안에 리턴하지 못하면 -1 출력
		return -1;
	}

}
