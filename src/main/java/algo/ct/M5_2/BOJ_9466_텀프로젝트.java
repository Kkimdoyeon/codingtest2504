package algo.ct.M5_2;

import java.io.*;
import java.util.*;

public class BOJ_9466_텀프로젝트 {

    static int[] graph;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());
            graph = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(n - count).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        int next = graph[node];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            count++;
            for (int temp = next; temp != node; temp = graph[temp]) {
                count++;
            }
        }

        finished[node] = true;
    }
}
