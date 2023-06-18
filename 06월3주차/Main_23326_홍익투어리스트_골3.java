package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_23326_홍익투어리스트_골3 {
	static int N, M, dh;
	static TreeSet<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		set = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == 1) {
				set.add(i);
			}
		}
		dh = 0;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 3) {
				sb.append(search(dh)).append("\n");
			} else if (num == 2) {
				int x = Integer.parseInt(st.nextToken());
				dh = (dh + x) % N;
			} else {// num==1일때
				int i = Integer.parseInt(st.nextToken()) - 1;
				if (set.contains(i))
					set.remove(i);
				else
					set.add(i);
			}
		}
		System.out.println(sb);

	}

	public static int search(int dh) {
		if (set.isEmpty())
			return -1;
		if (set.contains(dh))
			return 0;
		Integer loca = set.ceiling(dh);
		if (loca != null) {
			return loca - dh;
		} else {
			return N-dh + set.first(); // 무조건시계방향이여야하니까 
		}

	}

}
