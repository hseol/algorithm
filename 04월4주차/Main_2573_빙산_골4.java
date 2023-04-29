/**
 * 
 */
package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2573_빙산_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 30.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2573_빙산_골4 {
	static int N, M;
	static int map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		int year = 0, answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		while (!zeroIce()) {
			year++;
			melting();
			if (!isOne() && !zeroIce()) {
				answer = year;
				break;
			}
		}
		System.out.println(answer);

	}

	public static void melting() {
		List<Ice> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					list.add(new Ice(i, j, map[i][j]));
				}
			}
		} // 입력 끝

		for (int i = 0; i < list.size(); i++) {
			Ice ice = list.get(i);
			int count = 0;
			for (int d = 0; d < 4; d++) {
				int nr = ice.r + dr[d];
				int nc = ice.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 0)
					continue;
				count++;
			}
			if (list.get(i).floor - count < 0) {
				list.get(i).floor = 0;
			} else {
				list.get(i).floor -= count;
			}

		} // 얼음수대로
		for (int i = 0; i < list.size(); i++) {
			Ice ice = list.get(i);
			map[ice.r][ice.c] = ice.floor;
		} // 한꺼번에 갱신

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//
//		}System.out.println();
	}

	public static void island(int r, int c) {
		check[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || check[nr][nc])
				continue;
			island(nr, nc);
		}

	}

	public static boolean isOne() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			Arrays.fill(check[i], false);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !check[i][j]) {
					count++;
					island(i, j);
				}
			}
		}
		// System.out.println("count "+count);
		if (count == 1)
			return true;
		else {
			return false;
		}
	}

	public static boolean zeroIce() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static class Ice {
		int r;
		int c;
		int floor;

		public Ice(int r, int c, int floor) {
			this.r = r;
			this.c = c;
			this.floor = floor;
		}
	}
}
