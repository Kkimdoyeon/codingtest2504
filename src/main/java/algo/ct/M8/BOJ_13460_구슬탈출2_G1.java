package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 방향 좌우상하로 같이 움직임
// # 이면 벽, o는 구멍
// 이동횟수가 10번 초과하면 -1 출력
public class BOJ_13460_구슬탈출2_G1 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int result = 0;
    static int blackX, blackY;
    static int redX, redY;
    static int goalX, goalY;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'B') {
                    blackX = i;
                    blackY = j;
                }
                else if (map[i][j] == 'R') {
                    redX = i;
                    redY = j;
                }
                else if (map[i][j] == 'o') {
                    goalX = i;
                    goalY = j;
                }

                // 범위 처리하면 없어도 될 것 같긴 한데..
                if (map[i][j] == '#') {
                    visited[i][j] = true;
                }
            }
        }

        bfs(1, 1);
        System.out.println(result);
    }

    public static void bfs(int x, int y) {
        if (visited[x][y] == false)
            visited[x][y] = true;
        else return;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            x = a[0];
            y = a[1];
            for (int dist = 0; dist < 4; dist++) {
                int cx = x + nx[dist];
                int cy = y + ny[dist];

                if (cx <= 0 || cy <= 0 || cx >= N-1 || cy >= M-1)
                    continue;

                if (map[cx][cy] == '#')
                    continue;

                if (!visited[cx][cy]) {
                    visited[cx][cy] = true;
                    queue.add(new int[]{cx, cy});
                    result++;
                }

                if (map[cx][cy] == 'o')
                    return;
            }
        }
    }
}
