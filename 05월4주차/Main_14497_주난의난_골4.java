/**
 * 
 */
package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_14497_주난의난_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 27.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_14497_주난의난_골4 {
	static int N, M;
	static char map[][];
	static PriorityQueue<Node> pq;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		check = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		Node junan = new Node((Integer.parseInt(st.nextToken()) - 1), (Integer.parseInt(st.nextToken()) - 1), 1);
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();

		} // 입력 끝
		check[junan.r][junan.c] = true;
		pq.offer(junan);
		jump();
	}

	public static void jump() {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (map[node.r][node.c] == '#') {// 종료
				System.out.println(node.time);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || check[nr][nc])
					continue;
				check[nr][nc] = true;
				if (map[nr][nc] == '1') {
					pq.offer(new Node(nr, nc, node.time + 1));
				} else {
					pq.offer(new Node(nr, nc, node.time));
				}
			}
		}

	}

	public static class Node implements Comparable<Node> {
		int r;
		int c;
		int time;

		public Node(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}

	}
}
