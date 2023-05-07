
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_17070_파이프옮기기1_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 7.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_17070_파이프옮기기1_골5_DP {
	static int[] dr = { 1, 0, 1 };// 세로, 가로, 대각선
	static int[] dc = { 0, 1, 1 };
	static int N, map[][];
	static boolean check[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		check[0][0] = true;
		check[0][1] = true;
		Node node  = new Node(0,1,1);
		pipe(node);
		System.out.println(count);

	}

	static int count = 0;

	public static void pipe(Node node) {
			if (node.r == N - 1 && node.c == N - 1) {
				// System.out.println("들어오긴 해요..?");
				count++;
				return;
			}
			// dir ==0 일땐 0,2만 가능
			// dir ==1 일땐 1,2만 가능
			// dir ==2 일땐 0,1,2 가능
			for (int d = 0; d < 3; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N||map[nr][nc]==1)continue;
				if(!isPossible(node,d))continue;
				// System.out.println("현재 [" + node.r + ", " + node.c + "] 다음으로 향할 곳 [" + nr +
				// ", " + nc + "] 방향은" + d);
				pipe(new Node(nr,nc,d));
			}

		}

	public static boolean isPossible(Node node, int d) {
		if (node.dir == 0 && d == 1)
			return false;
		if (node.dir == 1 && d == 0)
			return false;
		if (d == 2) {
			for (int i = 0; i < 3; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				if (map[nr][nc] == 1) {
					return false;
				}
			}

		}
		return true;

	}

	public static class Node {
		int r;
		int c;
		int dir;

		public Node(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}
