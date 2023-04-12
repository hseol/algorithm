package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2075_N번째큰수_실2 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o2-o1>0) {
					return 1;
				}else if(o2==o1) {
					return 0;
				}else {
					return -1;
				}
			}
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < N; i++) {
			answer = queue.poll();
		}
		System.out.println(answer);

	}

}