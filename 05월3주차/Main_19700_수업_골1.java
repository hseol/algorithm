package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*진짜 개같은 문제 
 * 범위를 잘 따져보자 */
public class Main_19700_수업_골1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Student> pq = new PriorityQueue<>();
		List<Integer> teams = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			pq.offer(new Student(height, limit));
		}
		while (!pq.isEmpty()) {
			Student student = pq.poll();
			int target = student.limit;
			upper(teams, target);
			int index = upper(teams, target);
			if (index == teams.size()) {
				teams.add(1);
			} else {
				teams.set(index, teams.get(index) + 1);
			}
		}
		System.out.println(teams.size());
	}

	public static int upper(List<Integer> teams, int target) {
		int start = 0;
		int end = teams.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (teams.get(mid) >= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	public static class Student implements Comparable<Student> {
		int height;
		int limit;

		public Student(int height, int limit) {
			this.height = height;
			this.limit = limit;
		}

		@Override
		public int compareTo(Student o) {
			return o.height - this.height;

		}
	}
}