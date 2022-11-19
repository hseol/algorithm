package algo1119;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_9328_열쇠 {
	
	static int h,w,count;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] key;
	static ArrayList<int[]>[] gates;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			visited = new boolean[h+2][w+2];
			key = new boolean[26];
			gates = new ArrayList[26];
			count = 0;
			for(int i=0; i<26; i++) gates[i]=new ArrayList<>();
			for(int i=0; i<h+2; i++) {
				for(int j=0; j<w+2; j++) {
					map[i][j]='.';
				}
			}
			
			for(int i=1; i<=h; i++) {
				String str = br.readLine();
				for(int j=1; j<=w; j++) {
					map[i][j]= str.charAt(j-1);
				}
			}
			
			String keyStr = br.readLine();
			if(!keyStr.equals("0")) {
				for(int i=0; i<keyStr.length(); i++) {
					int tmp = keyStr.charAt(i)-'a';
					key[tmp]=true;
				}
			}
			
			bfs();
			System.out.println(count);
		}	
	}

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= h + 2 || nc >= w + 2) {
                    continue;
                }

                if (map[nr][nc] == '*' || visited[nr][nc]) {
                    continue;
                }

                int elem = map[nr][nc];
                if (elem - 'A' >= 0 && elem - 'A' <= 25) {
                    if (key[elem - 'A']) {
                        map[nr][nc] = '.';
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr,nc});
                    } else {
                        gates[elem - 'A'].add(new int[] {nr,nc});
                    }
                } else if (elem - 'a' >= 0 && elem - 'a' <= 25) {
                    key[elem - 'a'] = true;
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr,nc});

                    for (int j = 0; j <= 25; j++) {
                        if (gates[j].size() != 0 && key[j]) {
                            for (int z = 0; z < gates[j].size(); z++) {
                                int[] temp = gates[j].get(z);
                                map[temp[0]][temp[1]] = '.';
                                visited[temp[0]][temp[1]] = true;
                                q.offer(new int[] {temp[0], temp[1]});
                            }
                        }
                    }
                    count++;
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr,nc});
                } else {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr,nc});
                }

            }
        }
    }
}
