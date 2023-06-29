import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또_실2 {
	static int[] numbers, select;
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		while (N != 0) {
			numbers = new int[N];
			select = new int[6];
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			Combi(0, 0);
			sb.append("\n");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);

	}

	public static void Combi(int start, int cnt) {
		if (cnt == 6) {
			for (int i : select) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			select[cnt] = numbers[i];
			Combi(i + 1, cnt + 1);
		}
	}

}
