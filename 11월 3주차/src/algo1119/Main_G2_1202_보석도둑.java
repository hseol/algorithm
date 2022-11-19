package algo1119;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//127084KB 1680ms
public class Main_G2_1202_보석도둑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewelry[] jewels = new Jewelry[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewelry(M,V);
		}
        Arrays.sort(jewels);
		
		int[] bag = new int[K];
		for(int i=0; i<K; i++) {
			bag[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long ans = 0;
		for(int i=0, j=0; i<K; i++) {
            while (j < N && jewels[j].m <= bag[i]) {
                pq.offer(jewels[j++].v);
            }
            
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
		}
		System.out.println(ans);
	}

	static class Jewelry implements Comparable<Jewelry> {
		int m;
		int v;
		
		public Jewelry(int m, int v) {
			this.m=m;
			this.v=v;
		}

		@Override
		public int compareTo(Jewelry o) {
			return this.m==o.m? o.v-this.v : this.m-o.m;
		}
	}
}
