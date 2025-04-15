package main.java.algo.ct.M4_1;

import java.io.*;
import java.util.*;

public class BOJ_11437 {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
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

        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(1, 0);  // 루트 노드부터 시작

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(lca(u, v)).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int current, int d) {
        visited[current] = true;
        depth[current] = d;

        for (int next : tree[current]) {
            if (!visited[next]) {
                parent[next] = current;
                dfs(next, d + 1);
            }
        }
    }

    static int lca(int a, int b) {
        // 깊이를 같게 맞추기
        while (depth[a] > depth[b]) {
            a = parent[a];
        }
        while (depth[b] > depth[a]) {
            b = parent[b];
        }

        // 동시에 올라가며 공통 조상 찾기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}

