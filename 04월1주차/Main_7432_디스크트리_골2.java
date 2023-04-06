/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

  * @FileName : Main_7432_디스크트리_골2.java

  * @Project : NewAlgo

  * @Date : 2023. 4. 6. 

  * @작성자 : hseol

  * @변경이력 :

  * @프로그램 설명 :

  */
public class Main_7432_디스크트리_골2 {
	static class TrieNode{
		Map<String, TrieNode>childnode = new HashMap<>();
		TrieNode(){ //생성자
			
		}
		public void insert(String str) {
			TrieNode tra = this;
			String[] ss = str.split("\\\\");
			for(String s : ss) { //없으면 새로 넣고 아래로 내려가고 
				// 있으면 s가 있는 찰드노드로 이동.
				tra.childnode.putIfAbsent(s, new TrieNode());
				tra = tra.childnode.get(s);
			}
		}
		
		public void print(TrieNode cur,int depth) {
			TrieNode tra = cur; //출력하고자 하는 노드
			if(tra.childnode!=null) {
				//맵 값 출력하는거 전체출력  entrySet(), 키만 출력 keySet()
				List<String>list = new ArrayList<>(tra.childnode.keySet());
				Collections.sort(list);
				for(String str : list) {
					for(int i=0;i<depth;i++) {
						System.out.print(" ");
					}
					System.out.println(str);
					print(tra.childnode.get(str),depth+1);
				}
				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TrieNode tra = new TrieNode();
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			tra.insert(line);
		}
		tra.print(tra, 0);
	}

}
