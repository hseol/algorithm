import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16985_Maaaaaaaaaze_골2 {
	static int[][][] map, copymap;
	static boolean visit[][][], isSelected[];
	// 올라간다 내려간다 상하좌우
	static int[] df = { -1, 1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, -1, 1 };
	static int answer;
	static Queue<Loca> queue;
	static int[] orderK, orderR;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 임의적으로 0,0,0을 입구로 둘 것이다
		// 그러면 무조건 4,4,4 가 출구여야함
		// 이론 상 최단거리는 12이므로 그게 나오면 끝내자
		// 판의 순서를 결정
		// 순서가 결정됐으면 회전을 얼마나 할건지 결정
		// 그걸 조합해서 새로운 판을 만들기
		map = new int[5][5][5];
		copymap = new int[5][5][5];
		isSelected = new boolean[5];
		orderK = new int[5];
		orderR = new int[5];
		queue = new LinkedList<>();
		answer = Integer.MAX_VALUE;
		for (int k = 0; k < 5; k++) {// 판
			for (int i = 0; i < 5; i++) {// 행
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 5; j++) {// 열
					map[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		order(0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	public static void order(int cnt) { // 0,1,2,3,4 라는 판이 있다 그걸 순열돌리기
		if (cnt == 5) {
			// 판 회전하는 함수
			rotation(0);
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!isSelected[i]) {
				orderK[cnt] = i;
				isSelected[i] = true;
				order(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void rotation(int cnt) {
		// 중복순열을 하겠어요
		// 각 판때기는 0,1,2,3 을 고를 수 있다
		// 0 :제자리,1 : 시계방향으로 90,2:시계방향으로 180,3:시계방향으로 270
		if (cnt == 5) {
			copy();
			return;
		}
		for (int i = 0; i < 4; i++) {
			orderR[cnt] = i;
			rotation(cnt + 1);
		}
	}

	public static void copy() {
		for (int dir = 0; dir < 5; dir++) {
			int k = orderK[dir];
			int d = orderR[k];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					int num = map[k][i][j];
					if (d == 0) {
						copymap[dir][i][j] = num;
					} else if (d == 1) {
						copymap[dir][j][4 - i] = num;
					} else if (d == 2) {
						copymap[dir][4 - i][4 - j] = num;
					} else {// d==3
						copymap[dir][4 - j][i] = num;
					}
				}
			}

		}
		if ((copymap[0][0][0] == 1) && (copymap[4][4][4] == 1)) {
			bfs();
		}
	}

	public static void bfs() {
		// queue.clear();
		queue.offer(new Loca(0, 0, 0, 0));
		visit = new boolean[5][5][5];
		visit[0][0][0] = true;
		while (!queue.isEmpty()) {
			Loca loca = queue.poll();
			// System.out.println("현재위치"+loca.f+" "+loca.r+" "+loca.c+" "+loca.cnt);
			if ((loca.f == 4) && (loca.r == 4) && (loca.c == 4)) {
				if (loca.cnt == 12) {// 그러면 최단입니다
					System.out.println(12);
					System.exit(0);
				}
				answer = Math.min(answer, loca.cnt);
				continue;
			}
			for (int d = 0; d < 6; d++) {
				int nf = loca.f + df[d];
				int nr = loca.r + dr[d];
				int nc = loca.c + dc[d];
				if (nf < 0 || nr < 0 || nc < 0 || nf >= 5 || nr >= 5 || nc >= 5 || copymap[nf][nr][nc] != 1
						|| visit[nf][nr][nc])
					continue;
				queue.offer(new Loca(nf, nr, nc, loca.cnt + 1));
				visit[nf][nr][nc] = true;
			}
		}
	}

	public static class Loca {
		int f;
		int r;
		int c;
		int cnt;

		public Loca(int f, int r, int c, int cnt) {
			this.f = f;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
