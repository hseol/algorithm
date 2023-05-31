/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @FileName : Main_16934_게임닉네임_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 31.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_16934_게임닉네임_골3 {
	static int N;
	static Map<String, Integer> map;

	public static class Trie {
		Map<String, Trie> childnode = new HashMap<>();

		Trie() { // 초기화용
		}

//		public void insert(String str) {
//			Trie tra = this;
//			for (String letter : str.split("")) {
//				tra.childnode.putIfAbsent(letter, new Trie());
//				tra = tra.childnode.get(letter);
//			}
//		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<>();
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Trie trie = new Trie();
		Trie current;
		while (N-- > 0) {
			String word = br.readLine();
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
				sb.append(word).append(map.get(word)).append("\n");
				continue;
			} else {
				map.put(word, 1);
			}
			current = trie;
			// System.out.print(word + " ");
			// current.isLast =false;
			int index = 0;
			for (String letter : word.split("")) {
				// System.out.println(letter+"넣을게 ");
				if (current.childnode.containsKey(letter)) {
					// System.out.println("이상하다 없을리가");
					current = current.childnode.get(letter);
					index++;
				} else {
					current.childnode.put(letter, new Trie());
					current = current.childnode.get(letter);
				}
				// current = current.childnode.computeIfAbsent(letter, key -> new Trie());

			}

			if (index < word.length()) {// 갈라진 리프를 찾아서~
				sb.append(word.substring(0, index + 1)).append("\n");
			} else {// 완벽 일치한다면
				sb.append(word).append("\n");
			}
		}
		System.out.println(sb);

	}

}
