package main.java.algo.ct.M4_1;

import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS_S2 {
    static int N, M, V;
    static List<Integer>[] arr;
    static boolean visited[];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for (int i = 0; i < arr[idx].size(); i++) {
            int next = arr[idx].get(i);
            if (!visited[next])
                dfs(next);
        }
    }

    public static void bfs(int idx) {
        q.add(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            idx = q.poll();
            System.out.print(idx + " ");

            for (int i = 0; i < arr[idx].size(); i++) {
                int next = arr[idx].get(i);

                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
