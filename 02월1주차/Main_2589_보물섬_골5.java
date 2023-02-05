/**
 * 
 */
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2589_보물섬_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 5.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 : 1. 보물을 두곳 지정한다. 2. 그 사이의 최단거리를 구한다. 3. 그 중 제일 긴 거리를 구한다.
 * 
 */
public class Main_2589_보물섬_골5 {
	static int N, M,answer;
	static char map[][];
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		answer = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // 입력끝 //육지 L,바다 W
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
				distance(i,j);
				}
			}
		}
		System.out.println(answer);
	}

	public static void distance(int r, int c) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c,0 });// 시작점 넣기

		visited[r][c]=true;
		while (!queue.isEmpty()) {
			int[] loca = queue.poll();
			answer = Math.max(answer, loca[2]);
			for (int d = 0; d < 4; d++) {
				int nr = loca[0] + dr[d];
				int nc = loca[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] == 'W') {
					continue;
				}
				//System.out.println("내가 방문할 좌표 "+nr+" "+nc+" "+map[nr][nc]);
				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc,loca[2]+1 });
				
			}
		} // 와일 끝		
	}
}
/* 너무 직관적으로만 생각을 해서.. 실수한 문제... 
 * 나는 dfs로 두 지점을 무작위로 잡고 
 * 그 다음에 최단거리를 구한다음 마지막으로 제일 긴 거리로 구했었는데.. 흐어엉 ㅠㅠ 
 * 육지에서의 가장 긴 거리를 구하면 된다.. 
 * 근데 돌아가는건지 아닌지를 어케알징.. ㅠㅠ 흐어엉 */
