/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 
 * @FileName : Main_21944_문제추천시스템2_골2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 18.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_21944_문제추천시스템2_골2 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		TreeSet<Problem> set = new TreeSet<>();
		Map<Integer, TreeSet<Problem>> algoMap = new HashMap<>();
		Map<Integer, int[]> numberMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int diffi = Integer.parseInt(st.nextToken());
			int algo = Integer.parseInt(st.nextToken());
			set.add(new Problem(number, diffi, algo));
			numberMap.put(number, new int[] { diffi, algo });
			if (algoMap.containsKey(algo)) {
				TreeSet<Problem> temp = algoMap.get(algo);
				temp.add(new Problem(number, diffi, algo));
				algoMap.replace(algo, temp);
			} else {
				TreeSet<Problem> temp = new TreeSet<>();
				temp.add(new Problem(number, diffi, algo));
				algoMap.put(algo, temp);
			}
		} // 입력끝

		M = Integer.parseInt(br.readLine());

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("add")) {
				int number = Integer.parseInt(st.nextToken());
				int diffi = Integer.parseInt(st.nextToken());
				int algo = Integer.parseInt(st.nextToken());
				set.add(new Problem(number, diffi, algo));
				numberMap.put(number, new int[] { diffi, algo });
				if (algoMap.containsKey(algo)) {
					TreeSet<Problem> temp = algoMap.get(algo);
					temp.add(new Problem(number, diffi, algo));
					algoMap.replace(algo, temp);
				} else {
					TreeSet<Problem> temp = new TreeSet<>();
					temp.add(new Problem(number, diffi, algo));
					algoMap.put(algo, temp);
				}
			} else if (command.equals("recommend")) {
				int G = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					bw.write(algoMap.get(G).last().number + "\n");
				} else {
					bw.write(algoMap.get(G).first().number + "\n");
				}
			} else if (command.equals("recommend2")) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					bw.write(set.last().number + "\n");
				} else {
					bw.write(set.first().number + "\n");
				}
			} else if (command.equals("recommend3")) {
				int x = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				if (x == 1) {
					if (set.ceiling(new Problem(0, L, 0)) == null) {
						bw.write(-1 + "\n");
					} else {
						bw.write(set.ceiling(new Problem(0, L, 0)).number + "\n");
					}
				} else {
					if (set.floor(new Problem(0, L, 0)) == null) {
						bw.write(-1 + "\n");
					} else {
						bw.write(set.floor(new Problem(0, L, 0)).number + "\n");
					}
				}

			} else {
				int P = Integer.parseInt(st.nextToken());
				int diffi = numberMap.get(P)[0];
				int algo = numberMap.get(P)[1];
				numberMap.remove(P);
				set.remove(new Problem(P, diffi, algo));
				algoMap.get(algo).remove(new Problem(P, diffi, algo));
			}
		}
		bw.flush();
		bw.close();

	}

	public static class Problem implements Comparable<Problem> {
		int number;
		int diffi;
		int algo;

		public Problem(int number, int diffi, int algo) {
			this.number = number;
			this.diffi = diffi;
			this.algo = algo;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.diffi == o.diffi) {
				return this.number - o.number;
			} else {
				return this.diffi - o.diffi;
			}
		}
	}
}
