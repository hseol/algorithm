package BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7682_틱택토_골5 {
	static char[][] game;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		game = new char[3][3];

		while (true) {
			int Ogabing = 0, Xgabing = 0, Osebing = 0, Xsebing = 0, Odebing = 0, Xdebing = 0;
			str = br.readLine();
			int[] count = new int[3];
			if (str.equals("end"))
				break;// 종료조건
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					game[i][j] = str.charAt(i * 3 + j);
					if (game[i][j] == 'O') {
						count[0]++;
					} else if (game[i][j] == 'X') {
						count[1]++;
					} else {
						count[2]++;
					}
				}
			} // 입력

			if (Math.abs(count[1] - count[0]) > 1 || count[0] > count[1]) { 
				// O의 개수는 X보다 많을 수 없고 X가 O보다 2개이상클수없음
				System.out.println("invalid");
				continue;
			}

			for (int i = 0; i < 3; i++) {
				int Oga = 0, Ose = 0, Xga = 0, Xse = 0;
				for (int j = 0; j < 3; j++) {
					System.out.println(j + " " + i);
					// 가로탐색
					if (game[i][j] == 'O') {
						Oga++;
					} else if (game[i][j] == 'X') {
						Xga++;
					}
					// 세로탐색
					if (game[j][i] == 'O') {
						Ose++;
						System.out.println(Ose);
					} else if (game[j][i] == 'X') {
						Xse++;
					}

					if (Oga == 3) {
						Ogabing++;
					} else if (Ose == 3) {
						Osebing++;
					} else if (Xga == 3) {
						Xgabing++;
					} else if (Xse == 3) {
						Xsebing++;
					}

				}
			}
			int Ode = 0, Xde = 0;
			// 우하 대각선 탐색
			for (int i = 0; i < 3; i++) {
				if (game[i][i] == 'O') {
					Ode++;
				} else if (game[i][i] == 'X') {
					Xde++;
				}
			}

			if (Ode == 3)
				Odebing++;
			else if (Xde == 3)
				Xdebing++;

			Ode = 0;
			Xde = 0;
			// 좌하
			for (int i = 2; i >= 0; i--) {
				if (game[i][2 - i] == 'O') {
					Ode++;
				} else if (game[i][2 - i] == 'X') {
					Xde++;
				}
			}

			if (Ode == 3)
				Odebing++;
			else if (Xde == 3)
				Xdebing++;

			// 빙고해도 계속 게임하는 경우
			if (Ogabing > 1 || Osebing > 1 || Xsebing > 1 || Xgabing > 1) {
				System.out.println("invalid");
				continue;
			}

			if (count[0] == count[1]) { // 같을땐 O턴에서 끝나는거라서 O가 이김
				if (Xgabing > 0 || Xsebing > 0 || Xdebing > 0) {
					System.out.println("invalid");
					continue;
				}
			}
			if (count[0] < count[1]) { // X개수가 많으면 X가 이김
				if (Ogabing > 0 || Osebing > 0 || Odebing > 0) {
					System.out.println("invalid");
					continue;
				}
			}

			if (count[2] == 0) {// 게임이 꽉차면
				System.out.println("valid");
				continue;
			}
			if (Ogabing + Osebing + Xgabing + Xsebing + Odebing + Xdebing == 0) { // 빙고없으면
				System.out.println("invalid");
				continue;
			}

			System.out.println("valid");

		} //// while 문

	}

}
/*거지같은 틱택토... ji 로 해야되는데 jj로 해서 지금... 시간을 얼마나 날린걸까.. ㅠㅠ */