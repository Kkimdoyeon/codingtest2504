package algo.ct.M11;

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
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken());

            // 배열은 [세로][가로] = [N][M]
            arr = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // X = 가로
                int y = Integer.parseInt(st.nextToken()); // Y = 세로
                arr[y][x] = 1; // 반드시 arr[y][x]
            }

            int count = 0;

            // 전체 탐색하며 BFS
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arr[y][x] == 1 && !visited[y][x]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    // BFS : (x,y)를 기준으로 연결된 모든 배추 방문
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                // 배추 있고 방문 안 했으면 큐에 추가
                if (arr[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
