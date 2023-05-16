/**
 * 
 */
package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기_골4 {
	static int N, M, r, c, map[][], K, dice[];
	static int[] dr = { 0, 0, -1, 1 }; // 동서북남
	static int[] dc = { 1, -1, 0, 0 };
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dice = new int[7];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int k = Integer.parseInt(st.nextToken()) - 1;
			moving(k);
		} // 입력 끝
		System.out.println(sb);

	}

	public static void moving(int d) {
		int nr = r + dr[d];
		int nc = c + dc[d];
		if (nr < 0 || nc < 0 || nr >= N || nc >= M)
			return;
		location(d, nr, nc);
		r = nr;
		c = nc;

	}

	public static void location(int d, int r, int c) {
		int tmp = dice[1];
		if(d==0) {// 동
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
		}else if(d==1) {
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
		}else if(d==2) {// 북
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
		}else{// 남
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
		}
		if (map[r][c] == 0) {
			map[r][c] = dice[6];// 바닥인 면

		} else {
			dice[6] = map[r][c];
			map[r][c] = 0;
		}

		sb.append(dice[1]).append("\n");

	}

}
