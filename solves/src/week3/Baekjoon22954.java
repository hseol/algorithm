package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon22954 {
    static class Edge {
        int next;
        int index;

        Edge (int next, int index) {
            this.index = index;
            this.next = next;
        }
    }
    static boolean[] visited;
    static boolean[] isLeaf;
    static List<Edge>[] edges;
    static List<Integer>[] treeEdges;
    static List<Integer>[] treeNodes;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N == 1) {
            System.out.println("-1");
            return;
        }
        edges = new ArrayList[N + 1];
        treeNodes = new ArrayList[N + 1];
        treeEdges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
            treeNodes[i] = new ArrayList<>();
            treeEdges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, i));
            edges[v].add(new Edge(u, i));
        }

        visited = new boolean[N + 1];
        isLeaf = new boolean[N + 1];
        Arrays.fill(isLeaf, true);
        int countGraph = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, countGraph);
                countGraph++;
            }
        }

        if (countGraph > 2) {
            System.out.println("-1");
            return ;
        }

        if (countGraph < 2) {
            int target = 0;
            int now = 0;
            List<Integer> nodes = treeNodes[0];

            for (int node : nodes) {
                if (isLeaf[node]) {
                    target = node;
                }
                else now = node;
            }
            treeNodes[0].clear();
            treeEdges[0].clear();
            Arrays.fill(visited, false);
            visited[target] = true;
            dfs(now, 0);
            treeNodes[1].add(target);
            countGraph = 2;
        }

        if (countGraph == 2) {

            if (treeNodes[0].size() == treeNodes[1].size()) {
                System.out.println("-1");
                return ;
            }
        }

        printResult();
    }

    static void printResult() {

        StringBuilder sb = new StringBuilder();

        sb.append(treeNodes[0].size() + " " + treeNodes[1].size() + "\n");

        for (int node : treeNodes[0]) sb.append(node + " ");
        sb.append("\n");
        for (int edge : treeEdges[0]) sb.append(edge + " ");
        sb.append("\n");

        for (int node : treeNodes[1]) sb.append(node + " ");
        sb.append("\n");
        for (int edge : treeEdges[1]) sb.append(edge + " ");
        sb.append("\n");

        System.out.print(sb);
    }
    static void dfs(int now, int index) {
        visited[now] = true;
        treeNodes[index].add(now);

        List<Edge> nextNodes = edges[now];
        for (Edge edge : nextNodes) {
            if (visited[edge.next]) continue;
            isLeaf[now] = false;
            treeEdges[index].add(edge.index);
            dfs(edge.next, index);
        }
    }
}
