
package DFS;
//

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * 
// * @FileName : Main_10026_적록색약_골5.java
// * 
// * @Project : NewAlgo
// * 
// * @Date : 2023. 5. 9.
// * 
// * @작성자 : hseol
// * 
// * @변경이력 :
// * 
// * @프로그램 설명 :
// * 
// */
//public class Main_10026_적록색약_골5 {
//	static char map[][];
//	static boolean check[][];
//	static int[] dr = { -1, 1, 0, 0 };
//	static int[] dc = { 0, 0, -1, 1 };
//	static int N;
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		N = Integer.parseInt(br.readLine());
//		map = new char[N][N];
//		check = new boolean[N][N];
//		int result = 0;
//		
//		for (int i = 0; i < N; i++) {
//			map[i] = br.readLine().toCharArray();
//		} // 입력 끝
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (!check[i][j]) {
//					count(i, j);
//					result++;
//				}
//			}
//		}
//		sb.append(result).append(" ");
//		for(boolean[] b :check) {
//			Arrays.fill(b, false);
//		}
//		result =0;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (map[i][j] == 'G') {
//					map[i][j] = 'R';
//				}
//			}
//		}
//		
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (!check[i][j]) {
//					count(i, j);
//					result++;
//				}
//			}
//		}
//		sb.append(result);
//		System.out.println(sb);
//	}
//
//	public static void count(int r, int c) {
//		Queue<Node> queue = new LinkedList<>();
//		check[r][c] = true;
//		queue.offer(new Node(r, c));
//		while (!queue.isEmpty()) {
//			Node node = queue.poll();
//			for (int d = 0; d < 4; d++) {
//				int nr = node.r + dr[d];
//				int nc = node.c + dc[d];
//				if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc] || (map[node.r][node.c] != map[nr][nc]))
//					continue;
//				check[nr][nc] = true;
//				queue.offer(new Node(nr, nc));
//			}
//		}
//	}
//
//	public static class Node {
//		int r;
//		int c;
//
//		public Node(int r, int c) {
//			this.r = r;
//			this.c = c;
//
//		}
//	}
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_적록색약_골5 {
	static int[] dr = { -1, 0, 0, 1 }; // 상우좌하
	static int[] dc = { 0, 1, -1, 0 };
	static char[][] picture;
	static boolean[][] visited;
	static int N;
	static char start;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());// [N][N] 행렬
		picture = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			picture[i] = br.readLine().toCharArray();

		} /////// 맵생성완료
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					countArea(i, j, picture[i][j]);
					cnt++;

				}
			}

		}
		sb.append(cnt).append(" ");
		cnt = 0;// 초기화
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (picture[i][j] == 'G') {
					picture[i][j] = 'R';
				}
			}
		} // R로 바꿔주는 작업

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					countArea(i, j, picture[i][j]);
					cnt++;
				}
			}

		}
		sb.append(cnt);
		System.out.print(sb);

	}///////////// 메인

	public static void countArea(int r, int c, char start) {

		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || picture[nr][nc] != start)
				continue; // 방문안했으면 간다
			countArea(nr, nc, start);
		}
	}
}///////////// 끝
