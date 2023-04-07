package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집_골2 {
	static int R, C;
	static char[][] map;
	static int[] dir = { -1, 0, 1 };
	static boolean[][] isCheck;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		String str;
		map = new char[R][C];
		isCheck = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);

			}
		} // 맵 완성~

		for (int i = 0; i < R; i++) {
			pipe(i, 0);
		}
		System.out.println(result);
	}

	static public boolean pipe(int cr, int cc) {
		if (cc == C - 1) {// 빵집도착
			result++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nr = cr + dir[i];
			int nc = cc + 1;// 무조건 오른쪽으로 하나 가야됨
			if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'x' || isCheck[nr][nc]) {
				continue;
			}
			
			isCheck[nr][nc] = true;
			
			if (pipe(nr, nc)) {
				return true;
			}
		}
		return false;
	}
}

//재귀는 넘 헷갈령.. 
//charAt 말고 toCharArray 도 있음... 

