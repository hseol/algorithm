package algo1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S1_1946_신입사원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Applicant> pq = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				pq.add(new Applicant(paper, interview));
			}
			
			int start = pq.poll().interview;
			int res=1;
			while(!pq.isEmpty()) {
				Applicant cur = pq.poll();
				if(cur.interview < start) {
					start = cur.interview;
					res++;
				}
			}
			System.out.println(res);
		}
	}
	
	static class Applicant implements Comparable<Applicant> {
		int paper;
		int interview;
		
		public Applicant(int paper, int interview) {
			this.paper=paper;
			this.interview=interview;
		}
		
		@Override
		public int compareTo(Applicant o) {
			return this.paper-o.paper;
		}
	}
}
