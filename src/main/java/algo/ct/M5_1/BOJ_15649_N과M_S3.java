package main.java.algo.ct.M5_1;

import java.util.*;
import java.io.*;

public class BOJ_15649_N과M_S3 {
    static int N, M;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        visited = new boolean[N+1]; // 0번 인덱스 안 쓰니까
        // 숫자 1~N 썼는지 체크, 1번 썼으면 visited[1] = true; 이런 식

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                System.out.print(selected[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
