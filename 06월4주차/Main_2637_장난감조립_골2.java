/**
 * 
 */
package Topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2637_장난감조립_골2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 20.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2637_장난감조립_골2 {
	static int N, M;
	static List<Node>[] list;
	static int[] indegree1, indegree2;
	// static Node[] input;

	public static class Node {
		int Y;
		int K;

		public Node(int Y, int K) {
			this.Y = Y;
			this.K = K;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		indegree1 = new int[N + 1];
		indegree2 = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			list[X].add(new Node(Y, K));
			indegree1[X]++; //기본재료
			indegree2[Y]++;// 차수 체크
		}
		int[] result = topology(N);
		for(int i=1;i<=N;i++) {
			if(indegree1[i]==0) {
				sb.append(i).append(" ").append(result[i]).append("\n");
			}
		}
		System.out.println(sb);

	}

	public static int[] topology(int n) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(n, 1));
		int[] counter = new int[n + 1];
		counter[n] = 1;
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			for (int i = 0; i < list[current.Y].size(); i++) {
				Node next = list[current.Y].get(i);
				counter[next.Y] += counter[current.Y] * next.K;
				indegree2[next.Y]--;
				if (indegree2[next.Y] == 0) {
					queue.offer(new Node(next.Y, counter[next.Y]));
				}
			}
			
		}
		return counter;

	}
}
