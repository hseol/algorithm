
package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2412_암벽등반_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 19.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2412_암벽등반_골4 {
	static int N, T;
	static ArrayList<Integer>[] rock;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		rock = new ArrayList[200001];
		for (int i = 0; i < 200001; i++) {
			rock[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			rock[y].add(x);
		}

		for (int i = 0; i < 200001; i++) {
			Collections.sort(rock[i]);
		}

		System.out.println(bfs());
	}

	public static int bfs() {

		Queue<Loca> q = new LinkedList<>();
		q.offer(new Loca(0, 0));

		int move = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Loca loca = q.poll();
				if (loca.y == T)
					return move;
				for (int y = loca.y - 2; y <= loca.y + 2; y++) {
					if (y < 0 || y >= 200001)
						continue;
					for (int j = 0; j < rock[y].size(); j++) {
						int x = rock[y].get(j);
						if (loca.x + 2 < x)
							break;
						else if (loca.x - 2 > x)
							continue;

						rock[y].remove(j);
						q.add(new Loca(x, y));
						j--;
					}
				}
			}
			move++;
		}

		return -1;
	}

	public static class Loca {
		int x, y;

		public Loca(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
