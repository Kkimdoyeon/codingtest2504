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

    public static void main(String[] args) throws IOException { //4:24
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
                if (dfs(i, j))
                   result++;
            }
        }

        System.out.println(result);
    }

    public static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M)
            return false;

        if (!visited[x][y] && arr[x][y] == 0) { // 방문하지 않았고 더 갈 수 있는 0인 상태라면
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
