/**
 * 
 */
package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 20.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_14891_톱니바퀴_골5 {

	static int K, dir[], map[][];

	// 시계방향 1 내 뒤에 거 나의 3번 너의 6번, 반시계방향 -1 내 앞에거 나의 6번 너의 3번,
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][8];

		int answer = 0;
		for (int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// System.out.println(map[2][6]^map[3][2]);
		K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			dir = new int[5];
			dir[number] = direction;
			checkDir(number);
			moving();

		}
		for (int i = 1; i <= 4; i++) {
			if (map[i][0] == 1) {
				answer += Math.pow(2, i - 1);
			}

		}
		System.out.println(answer);

	}

	public static void checkDir(int number) {
		// 좌측
		for (int i = number - 1; i > 0; i--) {
			if (map[i+1][6] != map[i][2]) {// 같으면 반대방향
				dir[i] = -dir[i+1];
			} else {
				break;
			}
		}
		// 우측
		for (int i = number + 1; i <= 4; i++) {
			if (map[i][6] != map[i-1][2]) {// 같으면 반대방향
				dir[i] = -dir[i-1];
				
			} else {
				break;
			}
		}
	}

	public static void moving() {
		// 시계면 오른쪽으로 밀기
		// 반시계 왼쪽으로 밀기
		for (int j = 1; j <= 4; j++) {
			if (dir[j] == 1) {
				int tmp = map[j][7];
				for (int i = 7; i > 0; i--) {
					map[j][i] = map[j][i - 1];
				}
				map[j][0] = tmp;
//				System.out.println(j+"가 시계로 돌아요");
//				for(int k:map[j]) {
//					System.out.print(k+" ");
//				}System.out.println();
			} else if (dir[j] == -1) {
				int tmp = map[j][0];
				for (int i = 0; i < 7; i++) {
					map[j][i] = map[j][i + 1];
				}
				map[j][7] = tmp;
//				System.out.println(j+"가 반시계로 돌아요");
//				for(int k:map[j]) {
//					System.out.print(k+" ");
//				}System.out.println();
			}
		}

	}

}
/*
 * 8-Math.abs(a)%8 a%8
 */
