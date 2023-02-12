/**
 * 
 */
package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_4179_불_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 12.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_4179_불_골5 {
	static int N, M, Ji[];
	static char map[][];
	static boolean visited[][];
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		queue = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();

		} // 입력끝

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'J') {
					if (i == 0 || j == 0 || i == N - 1 || j == M - 1) { // 첫 위치 찾는데 그 위치가 가장자리이다.
						System.out.println(1);
						return;
					}
					map[i][j] = '.';
					Ji = new int[] { i, j, 0, 1 };
				} else if (map[i][j] == 'F') {
					queue.offer(new int[] { i, j, 1, 1 });// 불 1 시간 1부터 시작
				}

			}
		}
		fire();

	}

	// 내가 궁금한건... 동시겠지만... 불 먼저 갈까 내가 먼저 갈 수 있을까..
	public static void fire() {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		queue.offer(Ji);
		visited[Ji[0]][Ji[1]] = true;
		while (!queue.isEmpty()) {
			int[] loca = queue.poll();

		if ((loca[0] == 0 || loca[0] == N - 1 || loca[1] == 0 || loca[1] == M - 1) &&loca[2]==0) {
					System.out.println(loca[3]);
					return;
				}
			//ㅅㅂ.... 괄호 안쳐서.. 그랬다는게 넘 화가 나네... 
		
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			for (int d = 0; d < 4; d++) {
				int nr = loca[0] + dr[d];
				int nc = loca[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '#' || map[nr][nc] == 'F')
					continue;

				if (loca[2] == 0 && !visited[nr][nc]) {
					queue.offer(new int[] { nr, nc, loca[2], loca[3] + 1 });
					visited[nr][nc] = true;

//					for (int i = 0; i < N; i++) {
//						for (int j = 0; j < M; j++) {
//							System.out.print(visited[i][j] + " ");
//						}
//						System.out.println();
//					}
//					System.out.println();
					
				} else if (loca[2] == 1) {
					map[nr][nc] = 'F';
					queue.offer(new int[] { nr, nc, loca[2], loca[3] + 1 });

				}

			}

		}
		System.out.println("IMPOSSIBLE");
	}

}
