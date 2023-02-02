/**
 * 
 */
package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_14938_서강그라운드_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 3.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 : 기억하자 경찰도! 다익스트라 하려고해도 어차피 포문 한번 더 돌렸어야할듯
 * 
 */
public class Main_14938_서강그라운드_골4 {
	static int[][] map;
	static boolean[] visited;
	static int distance[], item[];
	static int N, M, r, a, b, l;
	static final int INF = 9999999;

	public static void main(String[] args) throws IOException {
		// 플로이드워셜 이용해서 행렬을 업데이트 시켜준다.
		// 완료된 행렬을 가지고 최대의 아이템 수를 세어준다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 지역개수
		M = Integer.parseInt(st.nextToken());// 수색범위
		r = Integer.parseInt(st.nextToken());// 선의개수
		map = new int[N][N];
		item = new int[N];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		} // 구역의 아이템개수
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], INF);
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			l = Integer.parseInt(st.nextToken());
			map[a][b] = l;
			map[b][a] = l;
		} // 입력 끝
		for (int i = 0; i < N; i++) {
			map[i][i] = 0;
		}

		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				if (i == k)
					continue; // 출발지와 경유지가 같다면 다음 출발지
				for (int j = 0; j < N; ++j) {
					if (i == j || k == j)
						continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}

		}

		distance = new int[N];

		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= M) {
					distance[i] += item[j];
				}
			}

			result = Math.max(result, distance[i]);
		}

		System.out.println(result);

	}

}
