package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2178_미로탐색_S1 {
    static int N, M;
    static int arr[][];
    static boolean[][] visited;
    static int[] nearX = {-1, 0, 1, 0};
    static int[] nearY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        arr = new int[N][M];

//        for (int i = 0; i < N; i++) {
//            char[] chars = br.readLine().toCharArray();
//            for (int j = 0; j < M; j++) {
//                arr[i].add(chars[j] - '0');
//            }
//        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                arr[i][j] = line.charAt(j) - '0';
        }

        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    // 상하좌우 체크해야되는군
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        arr[x][y] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + nearX[dir];
                int ny = cy + nearY[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (arr[nx][ny] == 0) continue; // 벽이면 통과 불가
                if (visited[nx][ny]) continue; // 방문했다면 통과 불가

                visited[nx][ny] = true;
                arr[nx][ny] = arr[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }
    }
}
