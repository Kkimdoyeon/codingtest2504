package algo.ct.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식_S2 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int result = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++)
            arr.add(new ArrayList<>());
        visited = new boolean[m+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        bfs(1, 0);
        System.out.println(result);
    }

    public static void bfs(int idx, int depth) {Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{idx, depth});
        visited[idx] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int dep = now[1];

            if (dep == 2) continue;

            for (int next : arr.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    result++;
                    q.add(new int[]{next, dep + 1});
                }
            }
        }
    }
}
