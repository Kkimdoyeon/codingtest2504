package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 8:14
public class 음료수_얼려먹기_BFS {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int result = 0;
    static int[] nearX = {-1, 0, 1, 0};
    static int[] nearY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (bfs(i, j))
                    result++;
            }
        }

        System.out.println(result);
    }

    public static boolean bfs(int x, int y) {
        if (visited[x][y] || arr[x][y] == 1) return false;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            x = a[0];
            y = a[1];

            for (int dist = 0; dist < 4; dist++) {
                int nx = x + nearX[dist];
                int ny = y + nearY[dist];

                // 1. 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 2. 얼음(0)인 곳만 탐색
                if (arr[nx][ny] == 1) continue;

                // 3. 아직 방문 안했으면 큐에 추가
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return true; // bfs 한 번 끝나면 새로운 덩어리 하나 탐색 성공
    }

}
