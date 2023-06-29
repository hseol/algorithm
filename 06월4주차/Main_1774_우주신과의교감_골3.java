import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1774_우주신과의교감_골3 {
	static int[] parents;
	static Node[] bbang;
	static int N, M;
	static double result = 0;
	static ArrayList<Dis> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		bbang = new Node[N + 1];
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int xx = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());
			bbang[i] = new Node(i, xx, yy);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				double distance = calcul(i, j);
				list.add(new Dis(i, j, distance));
			}
		}

		Collections.sort(list);

		for (int i = 0; i <list.size(); i++) {
			Dis current = list.get(i);
			if(find(current.start)!=find(current.end)) {
				result+=current.distance;
				union(current.start,current.end);
			}
		}

		System.out.printf("%.2f", result);

	}

	public static int find(int x) {
		if (parents[x] == x)
			return x;
		return find(parents[x]);

	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			// 이미 같다면
			return false;
		}
		if (x <= y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
		return true;
	}

	public static class Node {
		int num;
		int xx;
		int yy;

		public Node(int num, int xx, int yy) {
			this.num = num;
			this.xx = xx;
			this.yy = yy;
		}
	}

	public static class Dis implements Comparable<Dis> {
		int start;
		int end;
		double distance;

		public Dis(int start, int end, double distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}

		public int compareTo(Dis o) {
			if (this.distance > o.distance) {
				return 1;

			} else if (this.distance == o.distance) {
				return 0;
			} else
				return -1;
		}
	}

	public static double calcul(int num1, int num2) {
		double xxsquare = Math.pow(bbang[num1].xx - bbang[num2].xx, 2);
		double yysquare = Math.pow(bbang[num1].yy - bbang[num2].yy, 2);
		double distance = Math.sqrt(xxsquare + yysquare);
		return distance;
	}

}
