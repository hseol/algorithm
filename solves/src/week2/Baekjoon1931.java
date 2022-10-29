package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon1931 {

    public static class Conference implements Comparable<Conference>{
        int start;
        int end;

        Conference (int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Conference o) {
            if (this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = 0;
        int now = 0;
        ArrayList<Conference> list = new ArrayList<>();


        for (int i = 0; i < n; i++) { list.add(new Conference(sc.nextInt(), sc.nextInt()));}

        Collections.sort(list);

        for (Conference item : list){
            if (now <= item.start) {
                ret++;
                now = item.end;
            }
        }

        System.out.println(ret);
    }
}
