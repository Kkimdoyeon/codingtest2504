package main.java.algo.ct.M4_1;

import java.io.*;
import java.util.*;

public class BOJ_11438 {
    static int N, MAX;
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MAX = (int) Math.ceil(Math.log(N) / Math.log(2)); // 2^MAX ≥ N

        tree = new ArrayList[N + 1];
        parent = new int[MAX + 1][N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0);

        for (int k = 1; k <= MAX; k++) {
            for (int i = 1; i <= N; i++) {
                parent[k][i] = parent[k - 1][parent[k - 1][i]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // M개의 쿼리에 대해 LCA 계산
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(lca(u, v)).append('\n');
        }

        System.out.print(sb);
    }

    // DFS로 깊이와 1차 부모 설정
    static void dfs(int current, int d) {
        visited[current] = true;
        depth[current] = d;

        for (int next : tree[current]) {
            if (!visited[next]) {
                parent[0][next] = current; // 2^0 번째 부모 = 바로 위
                dfs(next, d + 1);
            }
        }
    }

    // 최소 공통 조상 찾기 (Binary Lifting)
    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int k = MAX; k >= 0; k--) {
            if (depth[a] - depth[b] >= (1 << k)) {
                a = parent[k][a];
            }
        }

        if (a == b) return a;

        for (int k = MAX; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        return parent[0][a]; // 둘의 부모가 같아졌으므로 그 부모가 LCA
    }
}
