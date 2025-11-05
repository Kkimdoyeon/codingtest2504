package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2_S2 {
    static int N, M;
    static int[][] arr;
    static int[][] dis;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dis = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    q.offer(new int[]{i, j}); // 상어 위치를 시작점으로
            }
        }

        // BFS 시작
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (arr[nx][ny] == 1) continue;

                // 아직 방문 안한 곳 (0이면서 dis가 0)
                if (dis[nx][ny] == 0) {
                    dis[nx][ny] = dis[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(dis[i][j], max);
            }
        }

        System.out.println(max);
    }
}
