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
 * @FileName : Main_1303_전쟁전투_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 19.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1303_전쟁전투_실1 {
	static char map[][];
	static int N, M,tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로 열
		M = Integer.parseInt(st.nextToken()); // 세로 행
		map = new char[M][N];
		int resultW = 0;
		int resultB = 0;
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'W') {
					map[i][j] = 'O';
					tmp = 1;
					counting(i, j, 'W');
					 resultW += Math.pow(tmp, 2);

				}
				if (map[i][j] == 'B') {
					map[i][j] = 'O';
					tmp = 1;
					counting(i, j, 'B');
					 resultB += Math.pow(tmp, 2);
				}

			}
		}
		 System.out.println(resultW+" "+resultB);

	}

	public static void counting(int r, int c, char mark) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= M || nc >= N || map[nr][nc] != mark)
				continue;
			map[nr][nc] = 'O';
			tmp++;
			counting(nr, nc, mark);
		}

	}

}
