package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_1213_팰린드롬만들기_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 15.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1213_팰린드롬만들기_실3 {
//A는 65 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] alpha = new int[26];
		String middle = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i) - 65]++;
		}
		int count = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] % 2 != 0) {
				count++;
				sb.append((char) (i + 65));
			}

		}
		middle = sb.toString();
		String answer = "";

		if (count > 1) {
			answer += "I'm Sorry Hansoo";
		} else {
			sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				int number = alpha[i] / 2;
				while (number-- > 0) {
					sb.append((char) (i + 65));
				}

			}
			answer += sb.toString();
			String end = sb.reverse().toString(); // 대박 미친 이런게 잇었다니 처음봐
			answer += middle + end;

		}
		System.out.println(answer);

	}

}
