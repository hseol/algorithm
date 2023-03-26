package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2583_영역구하기_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 26.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2583_영역구하기_실1 {
	static int N, M, K, area = 0;
	static int[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> arr = new ArrayList<>();
		int count = 0;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());

			for (int i = startR; i < endR; i++) {
				for (int j = startC; j < endC; j++) {
					map[i][j] = 1;
				}
			}
		} // 입력 끝
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !check[i][j]) {
					count++;
					area = 0;
					Area(i, j);
					arr.add(area);
				}

			}

		}
		Collections.sort(arr);
		System.out.println(count);
		for (int a : arr) {
			System.out.print(a + " ");
		}

	}

	public static void Area(int r, int c) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		check[r][c] = true;
		area++;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1 || check[nr][nc])
				continue;
			Area(nr, nc);

		}

	}

}
