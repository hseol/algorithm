/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_12891_DNA비밀번호_실2.java
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
public class Main_12891_DNA비밀번호_실2 {
	static int S, P, check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Character> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		char[] arr = new char[S];
		check = new int[4];// 0:A,1:c,2:G,3:T;
		int result = 0;
		String str = br.readLine();
		arr = str.toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			check[i] = -Integer.parseInt(st.nextToken());
			// System.out.println(check[i]);
		}

		// 첫번째 문자열은 해줘
		for (int i = 0; i < P; i++) {
			list.add(arr[i]);
		}
		for (char c : list) {
			check[swit(c)]++;
		}
		if (isRight()) {
			result++;
		}

		for (int i = P; i < S; i++) {
			check[swit(list.get(0))]--;
			list.remove(0);
			list.add(arr[i]);
			check[swit(list.get(P - 1))]++;
			if (isRight()) {
				result++;
			}
		}
		System.out.println(result);

	}

	public static boolean isRight() {
		for (int j = 0; j < 4; j++) {
			if (check[j] < 0) {
				return false;
			}
		}
		return true;
	}

	public static int swit(char c) {
		int result = 0;
		switch (c) {
		case 'A':
			result = 0;
			break;
		case 'C':
			result = 1;
			break;
		case 'G':
			result = 2;
			break;
		case 'T':
			result = 3;
			break;
		default:
			break;

		}
		return result;
	}

}
