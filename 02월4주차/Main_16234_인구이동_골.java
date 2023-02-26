
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_16234_인구이동_골.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 26.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */

public class Main_16234_인구이동_골 {

	static int N, L, R;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Node> list; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(move());
	}

	public static int move() { 
		int result = 0;
		while (true) {
			boolean isMove = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						int sum = bfs(i, j); 
						if (list.size() > 1) {
							changePopulation(sum); 
							isMove = true;
						}
					}
				}
			}
			if (!isMove)
				return result;
			;
			result++;
		}
	}

	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();

		q.offer(new Node(x, y));
		list.add(new Node(x, y));
		visited[x][y] = true;

		int sum = board[x][y];
		while (!q.isEmpty()) {
			Node current = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					int diff = Math.abs(board[current.x][current.y] - board[nx][ny]);
					if (L <= diff && diff <= R) {
						q.offer(new Node(nx, ny));
						list.add(new Node(nx, ny));
						sum += board[nx][ny];
						visited[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	}

	public static void changePopulation(int sum) {
		int avg = sum / list.size();
		for (Node n : list) {
			board[n.x][n.y] = avg;
		}
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}