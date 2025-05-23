package main.java.algo.ct.M5_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_창용마을무리의개수_D4 {
    static int T, N, M;
    static List<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
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

            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }

    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i < arr[x].size(); i++) {
            int next = arr[x].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}