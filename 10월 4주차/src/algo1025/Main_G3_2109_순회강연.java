package algo1025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//17444KB 288ms
public class Main_G3_2109_순회강연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.add(new Lecture(d,p));
		}
		
		boolean[] check = new boolean[10001];
		int max = 0;
		while(!pq.isEmpty()) {
			Lecture cur = pq.poll();
			for(int i=cur.day; i>=1; i--) {
				if(check[i]) continue;
				
				check[i]=true;
				max += cur.price;
				break;
			}
		}
		System.out.println(max);
	}
	
	static class Lecture implements Comparable<Lecture> {
		int day;
		int price;
		
		public Lecture(int day, int price) {
			this.day=day;
			this.price=price;
		}

		@Override
		public int compareTo(Lecture o) {
			return o.price==this.price? this.day-o.day : o.price-this.price;
		}
	}
}
