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
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        arr = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
                //arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        bfs(0, 0);
        System.out.println(dist[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        dist[x][y] = 1;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] a = q.poll();
            int dx = a[0];
            int dy = a[1];

            for (int i = 0; i < 4; i++) {
                int qX = dx + nx[i];
                int qY = dy + ny[i];

                if (qX < 0 || qY < 0 || qX >= N || qY >= M) continue;
                if (arr[qX][qY] == 0) continue;
                if (visited[qX][qY]) continue;

                dist[qX][qY] = dist[dx][dy] + 1;
                visited[qX][qY] = true;
                q.add(new int[]{qX, qY});
            }
        }
    }
}
