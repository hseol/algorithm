/**
 * 
 */
package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1368_물대기_골2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 17.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1368_물대기_골2 {
	static int N, non[], parent[], map[][], result = 0;
	static boolean visited[];
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		non = new int[N + 1];
		parent = new int[N + 1];
		visited = new boolean[N + 1];
		map = new int[N + 1][N + 1];
		pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			non[i] = Integer.parseInt(br.readLine());
			parent[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == j) {
					pq.offer(new Node(0, i, non[i]));// 새로 만들비용
				} else if (i < j) {
					pq.offer(new Node(i, j, map[i][j]));// 한쪽 면만 넣기위해서
				}
			}
		} // 입력 끝
		mst();

	}

	public static void mst() {
		
		while (!pq.isEmpty()) {
			Node nono = pq.poll();
			if(find(nono.start)==find(nono.end))continue;//이미 같은 트리라면
			union(nono.start,nono.end);
			result+=nono.cost;
		}
		System.out.println(result);

	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return find(parent[x]);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;// 이미 같은 트리
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
		return true;

	}

	public static class Node implements Comparable<Node> {
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

}
