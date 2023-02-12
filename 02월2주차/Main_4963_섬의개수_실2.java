/**
 * 
 */
package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_4963_섬의개수_실2.java
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
public class Main_4963_섬의개수_실2 {
	static int N, M, first, end, map[][], count = 0;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		first = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		while (first != 0 && end != 0) {
			
			System.out.println(first+" "+end);
			map = new int[first][end];
			visited = new boolean[first][end];
			count=0;
			for (int i = 0; i < first; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < end; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력끝

			for (int i = 0; i < first; i++) {
				for (int j = 0; j < end; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						count++;
						System.out.println(i+" "+j);
						dfs(i, j);
					}
				}
			}
			System.out.println(count);
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			System.out.println("====================================");
		}

	}

	public static void dfs(int r, int c) {
		int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
		visited[r][c] = true;
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= first || nc >= end || map[nc][nc] == 0 || visited[nr][nc]) {
				continue;
			}
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}

}
