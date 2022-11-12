package week4;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1197 {
    static class Edge implements  Comparable<Edge> {
        int start;
        int end;
        int w;

        Edge (int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo (Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ret = 0;
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge>[] adjList = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {

            int start = sc.nextInt();
            int end = sc.nextInt();
            int w = sc.nextInt();

            adjList[start].add(new Edge(start, end, w));
            adjList[end].add(new Edge(end, start, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.addAll(adjList[1]);
        int cnt = 1;

        visited[1] = true;

        while (cnt != V) {

            Edge cur = pq.poll();

            if (visited[cur.end]) continue;

            ret += cur.w;
            visited[cur.end] = true;
            pq.addAll(adjList[cur.end]);
            cnt++;
        }

        System.out.println(ret);

    }
}
