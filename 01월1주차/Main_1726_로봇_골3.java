package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇_골3 {
	static class Robot {
		int r, c, d, cnt;

		public Robot(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}
	}

	public static int[] dx = { 0, 0, 1, -1 }; //동서남북0123
	public static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][][] visit;
	static int R, C, answer = Integer.MAX_VALUE;
	static int sr, sc, sd, fr, fc, fd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visit = new boolean[4][R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력끝
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		sd = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		fr = Integer.parseInt(st.nextToken()) - 1;
		fc = Integer.parseInt(st.nextToken()) - 1;
		fd = Integer.parseInt(st.nextToken()) - 1;

		bfs();
		System.out.println(answer);

	}

	public static void bfs() {
		Queue<Robot> q = new LinkedList<>();
		q.add(new Robot(sr, sc, sd, 0));
		visit[sd][sr][sc] = true;

		while (!q.isEmpty()) {

			Robot robot = q.poll();
			if (robot.r == fr && robot.c == fc && robot.d == fd) {

				answer = Math.min(answer, robot.cnt);
				continue;
			}

			
			for (int j = 1; j <= 3; j++) { //얼마나 가야할지 모르니까 되는 칸까지 시도
				int nx = robot.r + dx[robot.d] * j;
				int ny = robot.c + dy[robot.d] * j;

				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;

				if (map[nx][ny] == 1)
					break;

				if (visit[robot.d][nx][ny]) {
					continue;
				}
				visit[robot.d][nx][ny] = true;
				q.offer(new Robot(nx, ny, robot.d, robot.cnt + 1));

			}

			int left = 0, right = 0;
			//0 동 1서 2남 3북
			//다음 방향 제시
			switch (robot.d) {
			case 0:
				left = 3;
				right = 2;
				break;
			case 1:
				left = 2;
				right = 3;
				break;
			case 2:
				left = 0;
				right = 1;
				break;
			case 3:
				left = 1;
				right = 0;
				break;
			}

			if (!visit[left][robot.r][robot.c]) {
				visit[left][robot.r][robot.c] = true;
				q.add(new Robot(robot.r, robot.c, left, robot.cnt + 1));
			}

			if (!visit[right][robot.r][robot.c]) {
				visit[right][robot.r][robot.c] = true;
				q.add(new Robot(robot.r, robot.c, right, robot.cnt + 1));
			}
		}
	}
}

/*
 * 처음에 생각해보고 도저히 모르겠어서 답지를 보고 거의 배낀.. 코드.. 
 * 방향 때문에 방문체크배열을 3차원을 해줬어야했다
 * 자꾸 한꺼번에 처리하려고 생각하는것 같음.. 나눠서.. 모든 경우의 수를 큐에 다 때려박는다는 생각으로..
 * 흑흑 */
 