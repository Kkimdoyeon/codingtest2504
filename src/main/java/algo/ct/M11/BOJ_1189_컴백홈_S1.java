package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시작: (R-1, 0) (맨 왼쪽 아래)
//도착: (0, C-1) (맨 오른쪽 위)
//정확히 K칸 이동
//벽('T')은 못 감
public class BOJ_1189_컴백홈_S1 {
    static int R, C, K;
    static int[][] road;
    static boolean[][] visited;
    static int count = 0;
    // 좌우상하
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        road = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (line[j].equals("."))
                    road[i][j] = 0;
                else
                    road[i][j] = 1;
            }
        }

        visited[R-1][0] = true;
        dfs(R-1, 0, 1);

        System.out.println(count);
    }

    public static void dfs(int x, int y, int dist) {
        // 도착지점이면 확인하기
        if (x == 0 && y == C-1) {
            if (dist == K)
                count++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            //범위 확인
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            // 방문 했는지, 방문이 가능한지 확인
            if (visited[nx][ny] == true || road[nx][ny] == 1) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, dist+1);
            visited[nx][ny] = false;
        }
    }
}
