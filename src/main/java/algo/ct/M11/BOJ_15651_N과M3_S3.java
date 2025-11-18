package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3_S3 {
    static int N, M;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                System.out.print(selected[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            selected[depth] = i;
            dfs(depth + 1);
        }
    }
}
