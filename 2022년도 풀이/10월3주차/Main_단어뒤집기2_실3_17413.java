package Oct3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_단어뒤집기2_실3_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		int N = str.length();
		boolean check = false;

		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == '<') {
				check = true;
				while (!stack.isEmpty()) { // 열린괄호만나면 그 전에 스택에 있는거 다 출력
					sb.append(stack.pop());
				}
			}
			if (check)
				sb.append(str.charAt(i));

			if (!check && str.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
			if (!check && str.charAt(i) != ' ')
				stack.add(str.charAt(i));
			if (str.charAt(i) == '>') {
				check = false;
			}
		}
		if (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}
		System.out.print(sb.toString());

	}

}
