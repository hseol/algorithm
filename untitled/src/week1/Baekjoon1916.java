package week1;

import java.util.*;

public class Baekjoon1916 {

    static class Node implements Comparable<Node>{
        int v;
        int cost;

        Node (int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();// number of city
        int M = sc.nextInt();// number of Bus
        List<Node>[] buses = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) buses[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) buses[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(dist, 100000000);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){

            Node cur = pq.poll();

            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            for (Node bus : buses[cur.v]){

                if (!visited[bus.v] && dist[bus.v] > dist[cur.v] + bus.cost){
                    dist[bus.v] = dist[cur.v] + bus.cost;
                    pq.add(new Node(bus.v, dist[bus.v]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}
