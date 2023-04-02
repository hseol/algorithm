/**
 * 
 */
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1781_컵라면_골2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 2.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1781_컵라면_골2 {
	static int N, max = 0;
	static long result;
	static PriorityQueue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ArrayList<Ramen> list = new ArrayList<>();
		queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dead = Integer.parseInt(st.nextToken());
			int many = Integer.parseInt(st.nextToken());
			//max = Math.max(max, many); // 최대 데드라인
			list.add(new Ramen(dead, many));
		}
		Collections.sort(list);
		for (int i = 0; i < N; i++) {
			int dead = list.get(i).deadline;
			int many = list.get(i).howmany;
			queue.offer(many);
			if (dead < queue.size()) {
				queue.poll();
			}
		}
		while (!queue.isEmpty()) {
			result += queue.poll();
		}
		System.out.println(result);

	}

	public static class Ramen implements Comparable<Ramen> {
		int deadline;
		int howmany;

		public Ramen(int deadline, int howmany) {
			this.deadline = deadline;
			this.howmany = howmany;
		}

		@Override
		public int compareTo(Ramen o) {

			return this.deadline - o.deadline;

		}
	}
}
