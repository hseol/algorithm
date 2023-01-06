package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_43164_여행경로_lev3 {
	static boolean[] check;
	static int index = 0;
	static String[] answer= {};
	static List<String> temp;

	public static void main(String[] args) {
		String[][] map = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
		solution(map);
		for (String str : answer) {
			System.out.print(str+" ");
		}
	}

	public static String[] solution(String[][] tickets) {
		check = new boolean[tickets.length];
		temp = new ArrayList<>();

//		Arrays.sort(tickets, new Comparator<String[]>() {
//			@Override
//			public int compare(String[] o1, String[] o2) {
//				return o1[1].compareTo(o2[1]);
//			}
//		});
		makeList("ICN", "ICN", tickets, 0);
		Collections.sort(temp);
		answer = temp.get(0).split(" ");
//		for (int i = 0; i < tickets.length; i++) {
//			if (tickets[i][0].equals("ICN")) {
//				// 표의 시작-
//				answer[index++] = "ICN";
//				check[i] = true;// 처음 넣는 그 배열 체크
//				makeList(tickets, tickets[i][1]);
//				break;
//			}
//
//		}
		return answer;
	}

	public static void makeList(String start, String desti, String[][] tickets, int depth) {

		if (depth == tickets.length) {
			temp.add(desti);
			return;
		} else {
			for (int i = 0; i < tickets.length; i++) {
				if (tickets[i][0].equals(start) && !check[i]) {
					check[i] = true;
					makeList(tickets[i][1], desti + " " + tickets[i][1], tickets, depth + 1);
					check[i] = false;
				}
			}
		}

	}
}
/*
 * 젠장~~~~ 백트래킹이었다니~~~~ 남은열~~~ 
 * 삽질이었지만 이 기회에 comparator를 사용해볼 수 있었습니다. 
 * list.get(0).split(" ") 이놈도 적용해볼일이 없었는데 잘 배웠네요.. 하하.. 
 * 처음에는 일반 DFS처럼 인천을 발견하면 경로를 작성하면 되는 건줄 알고 정렬을 먼저 한 후에 돌렸는데 
 * 예외처리를 안해준 것때문에.. 다른 테스트케이스에서 걸려버렸다.. 
 * 전체 노선을 다 들러야하는데 그냥 사전적 순서로 정렬을하고 돌리면 방문하지 않는 도시가 생기나봄.. 
 * 
 * */
