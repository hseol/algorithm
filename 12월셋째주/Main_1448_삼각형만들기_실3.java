package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1448_삼각형만들기_실3 {

	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int sum = 0, max = 0;
		// a+b>c

		for (int i = n - 1; i >= 2; i--) {
			int a = arr[i];
			int b = arr[i - 1];
			int c = arr[i - 2];

			if (arr[i] < arr[i - 1] + arr[i - 2]) {
				sum = a + b + c;
				if (max < sum)
					max = sum;
			}

		}

		if (sum == 0)
			System.out.println(String.valueOf(-1));
		else
			System.out.println(String.valueOf(max));

	}
}