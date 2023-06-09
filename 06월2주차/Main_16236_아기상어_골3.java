/**
 * 
 */
package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_16236_아기상어_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 9.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_16236_아기상어_골3 {
	static int N, map[][];
	static Babyshark baby = new Babyshark(0, 0, 0);
	static PriorityQueue<Babyshark> queue;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static class Babyshark implements Comparable<Babyshark> {
		int r;
		int c;
		int dis;

		public Babyshark(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		public int compareTo(Babyshark o) {
			if (this.dis == o.dis) {
				if (this.r == o.r) {
					return this.c - o.c;
				} else {
					return this.r - o.r;
				}
			} else {
				return this.dis - o.dis;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		queue = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					baby.r = i;
					baby.c = j;
					map[i][j] = 0;
				}
			}
		} // 입력 끝

		int size = 2;
		int fish = 0;
		int result = 0;

		while (true) {
			queue.clear();
			boolean[][] check = new boolean[N][N];
			queue.offer(baby);
			check[baby.r][baby.c] = true;
			boolean flag = true;

			while (!queue.isEmpty()) {
				baby = queue.poll();
				if (map[baby.r][baby.c] != 0 && map[baby.r][baby.c] < size) {// 현재위치에 먹을 물고기가 있는지
					map[baby.r][baby.c] = 0;
					fish++;
					result = baby.dis;
					flag = false;
					break;

				}

				for (int d = 0; d < 4; d++) {
					int nr = baby.r + dr[d];
					int nc = baby.c + dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc] || map[nr][nc] > size)
						continue;
					check[nr][nc] = true;
					queue.offer(new Babyshark(nr, nc, baby.dis + 1));
				}
			}
			if (flag) {
				// 먹이 못먹었단 소리임
				break;
			}
			if (size == fish) {// 내 크키만큼 물고기를 먹었다
				size++;
				fish = 0;
			}
		}
		System.out.println(result);

	}

}
