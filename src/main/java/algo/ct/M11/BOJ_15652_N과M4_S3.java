package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과M4_S3 {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        bfs(0, 1);
    }

    public static void bfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            bfs(depth + 1, i);
        }
    }
}