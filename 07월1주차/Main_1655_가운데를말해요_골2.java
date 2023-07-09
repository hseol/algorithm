import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요_골2 {
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);// 오름차순
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);// 내림차순

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (min.size() == max.size())
				max.offer(num);
			else
				min.offer(num);

			if (!min.isEmpty() && !max.isEmpty()) {
				if (min.peek() < max.peek()) {
					int tmp = min.poll();
					min.offer(max.poll());
					max.offer(tmp);
				}
			}

			sb.append(max.peek() + "\n");
		}
		System.out.println(sb);

	}
}