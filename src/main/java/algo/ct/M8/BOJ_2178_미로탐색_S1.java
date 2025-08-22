package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소의 칸 수 bfs
public class BOJ_2178_미로탐색_S1 {
    static int N, M;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(dist[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        // queue 배열로 만들어서 넣기
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        dist[x][y] = 1;

        // 네 방향으로 탐색하면서 queue에 계속 넣고.. 빼기
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            x = now[0];
            y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 1. 범위 벗어나면 무시
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 2. 길이 아니면 무시
                if (arr[nx][ny] == 0) continue;

                // 3. 이미 방문했으면 무시
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}
