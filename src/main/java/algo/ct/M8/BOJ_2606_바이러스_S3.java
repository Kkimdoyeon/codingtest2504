package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 9:31
public class BOJ_2606_바이러스_S3 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++)
            arr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        dfs(1);
        System.out.println(result-1);
    }

    public static void dfs(int idx) {
        if (visited[idx] == false)
            visited[idx] = true;
        else return;

        result++;
        for (int i = 0; i < arr.get(idx).size(); i++) {
            int next = arr.get(idx).get(i);
            dfs(next);
        }
    }
}
