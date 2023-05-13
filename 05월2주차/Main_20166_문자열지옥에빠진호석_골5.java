/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_20166_문자열지옥에빠진호석_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 13.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_20166_문자열지옥에빠진호석_골5 {
	static int N, M, K,max=0;
	static char map[][];
	static Map<String, Integer> hs;
	static String words[];
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		hs = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		words = new String[K];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			map[i] = tmp.toCharArray();
		} // 입력 끝
		
		for (int i = 0; i < K; i++) {
			String str = br.readLine();
			words[i] = str;
			max = Math.max(max, str.length());//너무 길어지는거 방지 
			hs.put(str, 0);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				stringMaker(i, j);
			}
		}
		sb = new StringBuilder();
		for(String str : words) {
			sb.append(hs.get(str)).append("\n");
		}
		System.out.println(sb);

	}

	public static void stringMaker(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, 1, map[r][c] + ""));
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.len > max)
				continue;
			if (hs.containsKey(node.word)) {
				hs.put(node.word, hs.get(node.word) + 1);
			}

			for (int d = 0; d < 8; d++) {
				int nr = (node.r + dr[d]) % N;
				int nc = (node.c + dc[d]) % M;

				if (nr < 0)
					nr += N;
				if (nc < 0)
					nc += M;
				
				queue.offer(new Node(nr, nc, node.len + 1, node.word + map[nr][nc]));
			}
		}
	}
	

	public static class Node {
		int r;
		int c;
		int len;
		String word;

		public Node(int r, int c, int len, String word) {
			this.r = r;
			this.c = c;
			this.len = len;
			this.word = word;
		}
	}

}
