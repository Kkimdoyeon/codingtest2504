package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추_S2 {
    static int T, M, N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};  // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 (열)
            N = Integer.parseInt(st.nextToken()); // 세로 (행)
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            arr = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 열
                int y = Integer.parseInt(st.nextToken()); // 행
                arr[y][x] = 1; // (y, x)에 배추 있음
            }

            int count = 0; // 지렁이 수 (즉, 연결된 덩어리 수)

            // 모든 칸 순회하면서 BFS 실행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 범위 벗어나면 continue
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 방문 안 했고, 배추가 있는 경우
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
