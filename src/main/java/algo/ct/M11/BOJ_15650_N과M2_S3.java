package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2_S3 {
    static int N, M;
    static boolean[] visited; // 왜 필요없지
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        dfs(0, 1);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                System.out.print(selected[i] + " ");
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}
