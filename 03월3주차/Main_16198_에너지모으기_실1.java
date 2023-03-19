package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_16198_에너지모으기_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 19.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_16198_에너지모으기_실1 {
	static int N;
	static boolean check[];
	static int arr[], result = 0, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Energy(0);
		System.out.println(answer);

	}

	public static void Energy(int cnt) {
		if (cnt == N - 2) {
			answer = Math.max(result, answer);
			return;
		}
		for (int i = 1; i < N - 1; i++) {
			if (check[i])
				continue;
			check[i] = true;
			int tmp = i - 1;
			while (check[tmp]) {
				tmp--;
			}
			int tmp2 = i + 1;
			while (check[tmp2]) {
				tmp2++;
			}
			int sum = arr[tmp] * arr[tmp2];
			result += sum;
			Energy(cnt + 1);
			check[i] = false;
			result -= sum;

		}
	}

}
