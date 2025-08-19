package algo.ct.M6;

import java.io.*;
import java.util.*;

public class BOJ_2206_벽부수고이동하기_G3 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, dist, wall; // 좌표, 이동거리, 벽 부쉈는지 여부(0: 안부숨, 1: 부숨)

        public Point(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        boolean[][][] visited = new boolean[N][M][2]; // [x][y][벽부숨여부]
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                return p.dist;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 빈칸
                if (arr[nx][ny] == 0 && !visited[nx][ny][p.wall]) {
                    visited[nx][ny][p.wall] = true;
                    queue.offer(new Point(nx, ny, p.dist + 1, p.wall));
                }

                // 벽이고 아직 안부쉈을 때
                if (arr[nx][ny] == 1 && p.wall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new Point(nx, ny, p.dist + 1, 1));
                }
            }
        }

        return -1;
    }
}
