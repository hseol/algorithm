/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 큐 두개 사용했을 때 108ms
 * 인덱스 써서 배열로 접근하고 다리 큐만 사용했을 때 96ms*/

public class Main_13335_트럭_실1 {
	static int n, w, l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> trucks = new LinkedList<>();
		int time = 0;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int weight = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			trucks.offer(num);
			arr[i] = num;
		}
		// 다리에 다 못올라갈거같으면 그대로 쭉
		// 아니면 계속 올리기
		for (int i = 0; i < w; i++) {
			queue.offer(0);
		}
		//int index =0;
		while (!queue.isEmpty()) {
			time++;
			weight -= queue.poll();
			if (trucks.isEmpty())
				continue;
			if (weight + trucks.peek() <= l) {
				weight += trucks.peek();
				queue.offer(trucks.poll()); // 무게가 되면 넣으셈
			} 
//			if (index>=n)
//				continue;
//			if (weight + arr[index] <= l) {
//				weight += arr[index];
//				queue.offer(arr[index]); // 무게가 되면 넣으셈
//				index++;
//			}
			else {
				queue.offer(0);
			}
		}
		System.out.println(time);
	}

}
