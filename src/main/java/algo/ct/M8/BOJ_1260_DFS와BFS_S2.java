package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260_DFS와BFS_S2 {
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++)
            arr.add(new ArrayList<>());
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i));
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }

    public static void dfs(int idx) {
        if (!visited[idx])
            visited[idx] = true;

        System.out.print(idx + " ");

        for (int i = 0; i < arr.get(idx).size(); i++) {
            int next = arr.get(idx).get(i);
            if (!visited[next]) {
                visited[next]= true;
                dfs(next);
            }
        }
    }

    public static void bfs(int idx) {
        if (!visited[idx])
            visited[idx] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");

            for (int i = 0; i < arr.get(x).size(); i++) {
                int next = arr.get(x).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
