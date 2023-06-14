/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1068_트리_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 14.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1068_트리_골5 {
	static int N, root;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		count = new int[N];
		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
			} else {
				tree.get(parent).add(i);
			}

		}

		int node = Integer.parseInt(br.readLine());
		remove(node);
	}

	public static void remove(int node) {
		loof: for (int i = 0; i < N; i++) {
			for (int j = 0; j < tree.get(i).size(); j++) {
				if (tree.get(i).get(j) == node) {
					tree.get(i).remove(j);
					break loof;
				}
			}
		}
		if (node != root) {
			leaf(root, -1);
		}
		System.out.println(count[root]);

	}

	public static void leaf(int number, int parent) {
		if (tree.get(number).size() == 0) {
			count[number] = 1;
		} else {
			for (int i : tree.get(number)) {
				if (i == parent)
					continue;
				leaf(i, number);
				count[number] += count[i];
			}
		}

	}

}
