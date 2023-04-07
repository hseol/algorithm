package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1913_달팽이_실3 {
static int map[][],N,number,snail;
static boolean[][]isVisit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = Integer.parseInt(br.readLine());
		snail=1;
		int d =0;
		int cr=N/2;
		int cc = N/2;
		int x=0,y=0;
		map = new int[N][N];
		isVisit= new boolean[N][N];
		// N/2로 나눈수부터 시작.. 
		//상 우 하 좌 로 시도하는데 만약에 true면 내가 했던거 한번더하고 다음 시도 
		map[cr][cc]=snail;
		isVisit[cr][cc]=true;
		bingle(cr,cc,0);
		
		for(int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if(map[i][j]==number) {
					x=i+1;
					y=j+1;
				}
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
		System.out.println(x+" "+y);

	}
	static public void bingle(int r,int c,int d) {
		int []dr = {-1,0,1,0};
		int[] dc= {0,1,0,-1};
		
		while(d<4) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr<0||nc<0||nr>=N||nc>=N) {
				continue;
			}
			
			if(isVisit[nr][nc]) {
				d--;
				if(d<0) {
					d=3;
				}
				continue;
			}
			
			map[nr][nc]=++snail;
			if(map[nr][nc]==N*N)break;
			isVisit[nr][nc]=true;
			r=nr;
			c=nc;
			d++;
			if(d>=4) {
				d=0;
			}

		
		}

	}

}
