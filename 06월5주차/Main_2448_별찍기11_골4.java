import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_2448_별찍기11_골4 {
//배열을 이용하자!!
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][2 * N - 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}
		makeStar(0, N - 1, N);
		for (int i = 0; i < map.length; i++) {
			// sb.append(map[i]);
			// sb.append("\n");
			bw.write(map[i]);
			bw.write("\n");
		}
		// System.out.println(sb);
		bw.flush();
		bw.close();

	}

	public static void makeStar(int r, int c, int n) {
		if (n == 3) {// 처음 모양
			map[r][c] = '*';
			map[r + 1][c - 1] = map[r + 1][c + 1] = '*';
			map[r + 2][c - 2] = map[r + 2][c - 1] = map[r + 2][c] = map[r + 2][c + 1] = map[r + 2][c + 2] = '*';
			return;
		}
		int size = n / 2;
		makeStar(r, c, size);
		makeStar(r + size, c - size, size);
		makeStar(r + size, c + size, size);

	}

}
