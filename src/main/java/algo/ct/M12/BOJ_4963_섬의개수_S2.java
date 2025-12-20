package algo.ct.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수_S2 {
    // 1이 섬, 0이 섬이 아닌 곳
    static int arr[][];
    static boolean visited[][];
    static int nx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int ny[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int num;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = (Integer.parseInt(st.nextToken()));
            h = (Integer.parseInt(st.nextToken()));

            if (w == 0 && h == 0) break;

            arr = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            num = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        num++;
                    }
                }
            }

            System.out.println(num);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int dx = cur[0] + nx[i];
                int dy = cur[1] + ny[i];

                if (dx < 0 || dy < 0 || dx >= h || dy >= w) continue;
                if (visited[dx][dy] == true) continue;

                if (arr[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    q.add(new int[]{dx, dy});
                }
            }
        }
    }
}
