package main.java.algo.ct.M4_1;

import java.io.*;
import java.util.*;

public class BOJ_1260_S2 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;

    static int node, line, start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for (int i = 0; i < line; i++) {
            String command = br.readLine();
            int a = Integer.parseInt(command.split(" ")[0]);
            int b = Integer.parseInt(command.split(" ")[1]);

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        bfs(start);
    }

    private static void dfs(int v) {
        for (int i = v; i < node+1; i++) {
            if (arr[i][i+1] == 1) {
                sb.append(i).append("\n");
            }
        }
    }

    private static void bfs(int start) {

    }
}
