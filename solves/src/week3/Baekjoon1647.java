package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1647 {
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int w;

        Edge (int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ret = 0;
        int V = sc.nextInt();
        int E = sc.nextInt();
        int max = 0;

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
        int count = 1;
        pq.addAll(adjList[1]);
        visited[1] = true;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.end]) continue;

            pq.addAll(adjList[cur.end]);
            visited[cur.end] = true;
            max = Math.max(max, cur.w);
            ret += cur.w;
            count++;

            if (count == V) break;
        }
        System.out.println(ret - max);
    }
}
