package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2:06
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

        for (int i = 0; i <= N; i++)
            arr.add(new ArrayList<>());
        visited = new boolean[N+1];

        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        dfs(1);
        System.out.println(result);
    }

    public static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < arr.get(idx).size(); i++) {
            int next = arr.get(idx).get(i);
            if (!visited[next]) {
                result++;
                dfs(next);
            }
        }
    }
}
