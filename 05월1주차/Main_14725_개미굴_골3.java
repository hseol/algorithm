/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_14725_개미굴_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 1.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_14725_개미굴_골3 {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		Trie trie = new Trie("");
		Trie current;

		N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			current = trie;// 현재 내 위치
			for (int i = 0; i < M; i++) { // 인서트 하는 작업
				String str = st.nextToken();
				boolean flag = true;
				for (int j = 0; j < current.list.size(); j++) {
					//System.out.println(str + " " + current.list.get(j).name);
					if (str.equals(current.list.get(j).name)) {
						current = current.list.get(j);
						flag = false;
						break;
					}
				}
				//System.out.println(N + " " + current.name + " " + str + " " + flag);
				// 못찾았다면
				if (flag) { // 트라이에 없으면 새로 만들어야해
					current.list.add(new Trie(str));
					current = current.list.get(current.list.size() - 1);// 최근에 넣었던 트라이로 갱신 (그래야 밑으로 들어감)
				}
			}
		}
		// 입력 끝
		print(trie, 0);
		System.out.println(sb);

	}

	public static void print(Trie trie, int depth) {
		Collections.sort(trie.list, new Comparator<Trie>() {

			@Override
			public int compare(Trie o1, Trie o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
		});

		String dep = "";
		for (int i = 0; i < depth; i++) {
			dep += "--";
		}

		for (int i = 0; i < trie.list.size(); i++) {
			sb.append(dep).append(trie.list.get(i).name).append("\n");
			print(trie.list.get(i), depth + 1);
		}
	}

	public static class Trie {
		List<Trie> list = new ArrayList<>();
		String name;

		Trie(String name) { // 초기화용
			list = new ArrayList<>();
			this.name = name;
		}
	}

}
