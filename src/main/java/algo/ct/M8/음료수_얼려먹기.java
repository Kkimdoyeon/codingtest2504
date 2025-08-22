package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수_얼려먹기 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int result = 0;

    // bfs, dfs 둘다 되는듯?
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
                if (dfs(i, j) == true)
                    result++;
            }
        }

        System.out.println(result);
    }

    public static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M)
            return false;

        if (arr[x][y] == 1)
            return false;

        if (!visited[x][y]) {
            visited[x][y] = true;

            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }
}
