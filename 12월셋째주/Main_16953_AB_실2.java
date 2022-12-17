package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953_AB {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int ans = B;
		int cnt = 1;
		while (ans > A) {
			cnt++;
			if (ans % 2 == 0) {// 짝수니?
				ans /= 2;
			} else if (ans % 10 == 1) {
				ans = (ans - 1) / 10;
			} else {
				cnt = -1;
				break;
			}
		}
		if (ans < A) {
			cnt = -1;
		}
		System.out.print(cnt);

	}

}
