package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon13424 {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int ret = 0;
            int[][] dist = new int[N][N];
            int[] minSum = new int[N];
            int minValue = Integer.MAX_VALUE;

            for (int n = 0; n < N; n++) Arrays.fill(dist[n], 1000000000);
            for (int n = 0; n < N; n++) dist[n][n] = 0;

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());

                dist[start][end] = Math.min(dist[start][end], w);
                dist[end][start] = Math.min(dist[end][start], w);
            }

            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int[] friends = new int[K];

            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < K; k++)  {
                friends[k] = Integer.parseInt(st.nextToken()) - 1;
            }

            floydWarshall(dist);

            for (int n = 0; n < N; n++) {
                for (int k = 0; k < K; k++) minSum[n] += dist[friends[k]][n];
            }

            for (int n = N - 1; n >= 0; n--) {
                if (minSum[n] <= minValue) {
                    minValue = minSum[n];
                    ret = n;
                }
            }
            System.out.println(ret + 1);
        }
    }
    static void floydWarshall(int[][] dist) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
    }
}
