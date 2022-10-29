package week2;

import java.util.*;
import java.util.stream.IntStream;

public class Baekjoon2109 {
    static class Lecture implements Comparable<Lecture>{

        int pay;
        int day;

        Lecture (int pay, int day){
            this.pay = pay;
            this.day = day;
        }
        @Override
        public int compareTo(Lecture o) {
            if (this.day == o.day){
                return o.pay - this.pay;
            }
            return this.day - o.day;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int limit = 0;
        int now = 0;
        int ret = 0;
        List<Lecture> lectureList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        IntStream.range(0, n).forEach( i -> {
            lectureList.add(new Lecture(sc.nextInt(), sc.nextInt()));
        });
        Collections.sort(lectureList);

        for (Lecture item : lectureList) {
            if (item.day > limit) limit++;
        }

        for (Lecture item : lectureList) {
            if (now < item.day){
                now++;
                pq.add(item.pay);
            }

            else {
                if (pq.peek() < item.pay) {
                    pq.poll();
                    pq.add(item.pay);
                }
            }

        }
        while (!pq.isEmpty()) ret += pq.poll();

        System.out.println(ret);
    }
}