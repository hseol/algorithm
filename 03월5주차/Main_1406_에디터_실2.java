/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1406_에디터_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 28.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 : 이전에 실패했던 문제.. 풀기 1년전 쯤 무수히 많은 시도했지만 못풀었음.. 결국... 스택을 유도하는 문제였군.. 쳇
 *       왔다리갔다리 할때는 스택을 이용하자
 * 
 * 
 */
public class Main_1406_에디터_실2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			left.add(str.charAt(i));
		}
		while (M-- > 0) {
			String mark = br.readLine();
			if (mark.charAt(0) == 'L') {
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
			} else if (mark.charAt(0) == 'D') {
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
			} else if (mark.charAt(0) == 'B') {
				if (!left.isEmpty()) {
					left.pop();
				}
			} else if (mark.charAt(0) == 'P') {
				left.push(mark.charAt(2));
			}
		}
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		while (!right.isEmpty()) {
			bw.write(right.pop());
		}
		bw.flush();
		bw.close();

	}

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		ArrayList<Character> list = new ArrayList<>();
//		StringTokenizer st;
//		String str = br.readLine();
//		int index;
//		for (int i = 0; i < str.length(); i++) {
//			list.add(str.charAt(i));
//		}
//		index = list.size();
//		int M = Integer.parseInt(br.readLine());
//		while (M-- > 0) {
//			st = new StringTokenizer(br.readLine());
//			String mark = st.nextToken();
//			switch (mark) {
//			case "L":
//				if (index != 0) {
//					index--;
//				}
//				break;
//			case "D":
//				if (index != list.size()) {
//					index++;
//				}
//				break;
//			case "B":
//				if (index != 0) {
//					index--;
//					list.remove(index);
//				}
//				break;
//			case "P":
//				list.add(index, st.nextToken().charAt(0));
//				index++;
//				break;
//			default:
//				break;
//			}
//		}
//		for(char c : list) {
//			System.out.print(c);
//		}
//
//	}

}
