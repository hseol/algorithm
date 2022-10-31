package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1946_신입사원_실1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		PriorityQueue<applicant> pq = new PriorityQueue<>();
		int T = Integer.parseInt(br.readLine());
		int result;
		while (T-- > 0) {// 테케
			N = Integer.parseInt(br.readLine());
			//pq.clear();
			while (N-- > 0) {// 몇명 받는지 순위
				st = new StringTokenizer(br.readLine());
				pq.add(new applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			result = 1;
			int min=pq.poll().interview;
			while (!pq.isEmpty()) {
				int b=pq.poll().interview;
				// System.out.println(a+" "+b);
				if (min > b) {
					result++;
					min = b;
				}
			}
			
			System.out.println(result);
		}

	}

	public static class applicant implements Comparable<applicant> {
		int paper;
		int interview;

		public applicant(int paper, int interview) {
			this.paper = paper;
			this.interview = interview;
		}

		@Override
		public int compareTo(applicant o) {
			// TODO Auto-generated method stub
			return this.paper - o.paper;
		}
	}

}
