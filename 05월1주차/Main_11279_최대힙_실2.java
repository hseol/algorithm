/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 * @FileName : Main_11279_최대힙_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 7.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_11279_최대힙_실2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.isEmpty()) {
					// sb.append(num).append("\n");
					System.out.println(num);
				} else {
					// sb.append(pq.poll()).append("\n");
					System.out.println(pq.poll());
				}
			} else {
				pq.offer(num);
			}
		}
		// System.out.println(sb);
	}

}
