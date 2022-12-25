package 흑흑난몰라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21772_가희의고구마먹방_골5 {
	public static int R, C, T;
	public static char[][] room;
	public static int cx = -1, cy = -1;
	public static int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		room = new char[R][C];

		for (int x = 0; x < R; x++) {
			String temp = br.readLine();

			for (int y = 0; y < C; y++) {
				room[x][y] = temp.charAt(y);

				// 가희 위치 체크
				if (room[x][y] == 'G') {
					cx = x;
					cy = y;
				}
			}
		}

		System.out.println(dfs(cx, cy, T));

	}

	public static int dfs(int x, int y, int remain) {
		if (remain == 0) {
			return 0;
		}

		int ret = 0;
		char prev;
		int plus;

		for (int i = 0; i < 4; i++) {

			int nx = x + move[i][0];
			int ny = y + move[i][1];
			plus = 0;

			if (nx < 0 || ny < 0 || nx >= R || ny >= C || room[nx][ny] == '#') {
				continue;
			}

			plus = room[nx][ny] == 'S' ? 1 : 0;

			prev = room[nx][ny];
			room[nx][ny] = '.';

			ret = Math.max(ret, dfs(nx, ny, remain - 1) + plus);

			// 돌아갈때 다시
			room[nx][ny] = prev;
		}

		return ret;
	}

}
