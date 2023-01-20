
package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_13777_HuntTheRabbit_브1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 21.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_13777_HuntTheRabbit_브1 {
//1부터 50까지의 수가 있고 주어진 숫자를 탐색하는 과정을 출력하라 
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int answer = Integer.parseInt(br.readLine());
		while (answer != 0) {
			rabbit(answer, 1, 50);
			sb.append('\n');

			answer = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());

	}

	public static void rabbit(int target, int start, int end) {
		int mid = (start + end) / 2;
		sb.append(mid).append(" ");
		if (mid == target)
			return;
		else if (mid > target) {
			rabbit(target, start, mid-1);
		} else if (mid < target) {
			rabbit(target, mid+1, end);
		}
	}

}
