/**
 * 
 */
package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1261_알고스팟_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 29.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1261_알고스팟_골4 {
	static int N, M;
	static char map[][];
	static boolean check[][];
	static Deque<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // 입력끝
		bfs(0, 0);

	}

	public static class Node {
		//implements Comparable<Node>
		int r;
		int c;
		int block;

		public Node(int r, int c, int block) {
			this.r = r;
			this.c = c;
			this.block = block;
		}

//		public int compareTo(Node o) {
//			return this.block - o.block;
//		}
	}

	public static void bfs(int r, int c) {
		//PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		check[r][c] = true;
		queue.add(new Node(r,c,0));
		//pq.offer(new Node(r, c, 0));
		while (!queue.isEmpty()) {
			Node algo = queue.poll();
			if (algo.r == N - 1 && algo.c == M - 1) {
				System.out.println(algo.block);
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = algo.r + dr[d];
				int nc = algo.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || check[nr][nc])
					continue;
				check[nr][nc] = true;
				if (map[nr][nc] == '1') {
					queue.addLast(new Node(nr, nc, algo.block + 1));
				} else {
					queue.addFirst(new Node(nr, nc, algo.block));
				}
			}
		}
//		while (!pq.isEmpty()) {
//			Node algo = pq.poll();
//			if (algo.r == N - 1 && algo.c == M - 1) {
//				System.out.println(algo.block);
//				break;
//			}
//			for (int d = 0; d < 4; d++) {
//				int nr = algo.r + dr[d];
//				int nc = algo.c + dc[d];
//				if (nr < 0 || nc < 0 || nr >= N || nc >= M || check[nr][nc])
//					continue;
//				check[nr][nc] = true;
//				if (map[nr][nc] == '1') {
//					pq.offer(new Node(nr, nc, algo.block + 1));
//				} else {
//					pq.offer(new Node(nr, nc, algo.block));
//				}
//			}
//		}

	}

}
