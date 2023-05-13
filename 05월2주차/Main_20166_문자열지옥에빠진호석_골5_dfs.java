/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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
public class Main_20166_문자열지옥에빠진호석_골5_dfs {
	static int N, M, K, cnt = 0;
	static char map[][];
	static Map<String, Integer> hs;
	static String words[];
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		;
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
		}

		for (int t = 0; t < K; t++) {
			if (hs.containsKey(words[t])) {
				sb.append(hs.get(words[t])).append("\n");
			} else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (words[t].charAt(0) == map[i][j]) {
							stringMaker(i, j, 1, words[t]);
						}

					}
				}
				hs.put(words[t], cnt);
				sb.append(cnt).append("\n");
				cnt = 0;

			}
		}

		System.out.println(sb);

	}

	public static void stringMaker(int r, int c, int len, String word) {
		if (len == word.length()) {
			cnt++;
			return;
		}
		for (int d = 0; d < 8; d++) {
			int nr = (r + dr[d]) % N;
			int nc = (c + dc[d]) % M;

			if (nr < 0)
				nr += N;
			if (nc < 0)
				nc += M;
			if (word.charAt(len) == map[nr][nc])
				stringMaker(nr, nc, len + 1, word);
		}
		return;
	}

}
