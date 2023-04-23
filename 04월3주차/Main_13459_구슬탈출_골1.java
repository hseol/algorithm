package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13459_구슬탈출_골1 {
	static char map[][];
	static Queue<int[]> R, B;
	static int result;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		result = 0;
		R = new LinkedList<>();
		B = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R')
					R.add(new int[] { i, j, 0 });
				else if (map[i][j] == 'B')
					B.add(new int[] { i, j, 0 });
			}
		}
		search();
		System.out.println(result);
	}

	private static void search() {
		boolean check = false;

		while (!R.isEmpty()) {
			int[] R_temp = R.poll();
			int[] B_temp = B.poll();
			int x1, y1, x2, y2;
			for (int i = 0; i < 4; i++) {
				int temp = R_temp[2] + 1;
				if (temp > 10)
					break; // 10번 이하가 아니면 x
				x1 = R_temp[0];
				y1 = R_temp[1];
				check = false;
				while (true) { // 빨간 구슬
					x1 += dx[i];
					y1 += dy[i];

					if (map[x1][y1] == '#') {
						break;
					}
					if (map[x1][y1] == 'O') { // 구멍
						check = true;
						break;
					}
				}
				x2 = B_temp[0];
				y2 = B_temp[1];
				while (true) { // 파란 구슬
					x2 += dx[i];
					y2 += dy[i];
					if (map[x2][y2] == 'O') { // 파란구슬이 구멍에 빠지면 실패
						result = 0;
						break;
					}
					if (map[x2][y2] == '#') {
						if (x1 == x2 && y1 == y2) { // 빨간 구슬과 파란 구슬 좌표가 같으면 위치 조정
							if (i == 0) {
								if (B_temp[0] < R_temp[0]) {
									x2 -= dx[i];
									x1 = x2 - dx[i];
								} else {
									x1 -= dx[i];
									x2 = x1 - dx[i];
								}
							} else if (i == 1) {
								if (B_temp[0] < R_temp[0]) {
									x1 -= dx[i];
									x2 = x1 - dx[i];
								} else {
									x2 -= dx[i];
									x1 = x2 - dx[i];
								}
							} else if (i == 2) {
								if (B_temp[1] < R_temp[1]) {
									y2 -= dy[i];
									y1 = y2 - dy[i];
								} else {
									y1 -= dy[i];
									y2 = y1 - dy[i];
								}
							} else {
								if (B_temp[1] < R_temp[1]) {
									y1 -= dy[i];
									y2 = y1 - dy[i];
								} else {
									y2 -= dy[i];
									y1 = y2 - dy[i];
								}
							}
						} else {
							x1 -= dx[i];
							y1 -= dy[i];
							x2 -= dx[i];
							y2 -= dy[i];
							if (check) { // 최소 횟수
								result = 1;
								break;
							}
						}
						if (!(R_temp[0] == x1 && R_temp[1] == y1 && B_temp[0] == x2 && B_temp[1] == y2)) {
							R.add(new int[] { x1, y1, temp });
							B.add(new int[] { x2, y2, temp });
						}
						break;
					}
				}
				if (result == 1)
					break;
			}
			if (result == 1)
				break;
		}
	}
}