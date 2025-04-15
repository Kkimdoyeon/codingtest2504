package main.java.algo.ct.M4_2;

import java.io.*;
import java.util.*;

public class BOJ_14889_S1 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int depth, int idx) {
        if (depth == N / 2) {
            calc();
            return;
        }

        for (int i = idx; i < N; i++)
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false; // 백 트래킹
            }
    }

    // 능력치 계산 함수
    static void calc() {
        int start = 0, link = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j])
                    start += arr[i][j];
                else if (!visited[i] && !visited[j])
                    link += arr[i][j];
            }

        min = Math.min(min, Math.abs(start - link));
    }

}
