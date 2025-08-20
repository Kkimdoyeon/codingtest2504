package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260_DFS와BFS_S2 {
    static int N, M, V;
    static Queue<Integer> queue = new LinkedList<>(); // 후입선출
    static List<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1]; // 이거 안 하면 nullPointException
        arr = new ArrayList[N+1]; // 이거 안 하면 런타임 에러
        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(arr[i]);

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for (int i = 0; i < arr[idx].size(); i++) {
            int next = arr[idx].get(i);

            // 이걸 안 하게 되면 방문했던 곳도 계속 방문.. 그럼.. 끝이 없겠지요
            if (!visited[next])
                dfs(next);
        }
    }

    public static void bfs(int idx) {
        visited[idx] = true;
        queue.add(idx);

        while (!queue.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = queue.poll();
            System.out.print(x + " ");

            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < arr[x].size(); i++) {
                int next = arr[x].get(i);

                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
