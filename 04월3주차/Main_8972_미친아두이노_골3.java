package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Loca {
	int r;
	int c;

	public Loca(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main_8972_미친아두이노_골3 {

	static int N;
	static int M;
	static char[][] map;
	static int[][] check;

	static Loca jong;
	static ArrayList<Loca> crazy;

	static String directs;

	static int[] dr = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dc = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		crazy = new ArrayList<>();
		check = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					crazy.add(new Loca(i, j));
				}
				if (map[i][j] == 'I') {
					jong = new Loca(i, j);
				}
			}
		}
		directs = br.readLine();
		for (int i = 0; i < directs.length(); i++) {
			int d = directs.charAt(i) - '0';
			if (!moveRobot(d)) {
				System.out.println("kraj" + " " + (i + 1));
				return;
			}
			if (!moveMadRobots()) {
				System.out.println("kraj" + " " + (i + 1));
				return;
			}
		}
		printBoard();

	}

	// 1. 2. : 종수 아두이노 움직이기
	public static boolean moveRobot(int d) {
		int nr = jong.r + dr[d], nc = jong.c + dc[d];
		if (map[nr][nc] == 'R') {
			return false;
		}
		map[jong.r][jong.c] = '.';
		map[nr][nc] = 'I';
		jong.r = nr;
		jong.c = nc;
		return true;
	}

	public static boolean moveMadRobots() {
		for (Loca cur : crazy) {
			int d = getDirect(cur);
			if (!moveMadRobot(cur, d)) {
				return false;
			}
		}
		// 2개 이상 미친 로봇 지우고 갱신
		crazy.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j] >= 2) {
					map[i][j] = '.';
				} else if (check[i][j] == 1) {
					crazy.add(new Loca(i, j));
					map[i][j] = 'R';
				} else if (map[i][j] != 'I') {
					map[i][j] = '.';
				}
				check[i][j] = 0;
			}
		}

		return true;
	}

	public static boolean moveMadRobot(Loca cur, int d) {
		int nr = cur.r + dr[d], nc = cur.c + dc[d];
		if (map[nr][nc] == 'I') {
			return false;
		}
		check[nr][nc] += 1;
		cur.r = nr;
		cur.c = nc;
		return true;
	}

	public static int getDirect(Loca cur) {
		int minDist = Integer.MAX_VALUE;
		int direct = -1;
		for (int d = 1; d <= 9; d++) {
			int nr = cur.r + dr[d], nc = cur.c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N | nc >= M)
				continue;
			int dist = Math.abs(jong.r - nr) + Math.abs(jong.c - nc);
			if (dist < minDist) {
				minDist = dist;
				direct = d;
			}
		}
		return direct;
	}

	public static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
