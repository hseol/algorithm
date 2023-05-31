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

public class Main_7569_토마토_골5 {
	static int M, N, H, map[][][];
	static boolean check[][][];
	static int[] dr = { -1, 1, 0, 0, 0, 0 };// 동서남북 위 아래
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		Queue<Tomato> queue = new LinkedList<>();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		check = new boolean[N][M][H];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j][h] = Integer.parseInt(st.nextToken());
					if (map[i][j][h] == 1) {
						queue.offer(new Tomato(i, j, h, 0));
					}
				}
			}
		}
		int result = 0;
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			// System.out.println("현재위치"+tomato.h+"층"+tomato.r+" "+tomato.c);
			for (int d = 0; d < 6; d++) {
				int nr = tomato.r + dr[d];
				int nc = tomato.c + dc[d];
				int nh = tomato.h + dh[d];
				if (nr < 0 || nc < 0 || nh < 0 || nr >= N || nc >= M || nh >= H || check[nr][nc][nh]
						|| map[nr][nc][nh] == -1)
					continue;
				// System.out.println(d);
				// System.out.println("다음위치"+nh+"층"+nr+" "+nc);
				if(map[nr][nc][nh]==0) {
					check[nr][nc][nh] = true;
					map[nr][nc][nh] = 1;
					queue.offer(new Tomato(nr, nc, nh, tomato.days + 1));
				}

			}
			result = tomato.days;
		}
		if (!isPossible()) {
			result = -1;
		}
			
		System.out.println(result);
		// System.out.print(calcul());
//		for (int h = 0; h < H; h++) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j][h]+" ");
//				}System.out.println();
//			}System.out.println(h+"층");
//		}

	}

	public static class Tomato {
		int r;
		int c;
		int h;
		int days;

		public Tomato(int r, int c, int h, int days) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.days = days;
		}
	}
//	public static int calcul(){
//		int result =0;
//		for (int h = 0; h < H; h++) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if(map[i][j][h]==0) {
//						return -1;
//					}
//					result = Math.max(result, map[i][j][h]);
//				}
//			}
//		}
//		result-=1;
//		return result;
//	}

	public static boolean isPossible() {
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][h] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
