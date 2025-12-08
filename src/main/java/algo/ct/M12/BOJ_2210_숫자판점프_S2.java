package algo.ct.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2210_숫자판점프_S2 {
    static int[][] arr = new int[5][5];
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};
    static HashSet<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, "");
            }
        }

        System.out.println(answer.size());
    }

    public static void dfs(int x, int y, int depth, String str) {
        if (depth == 6) {
            answer.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dx = x + nx[i];
            int dy = y + ny[i];

            if (dx >= 0 && dy >= 0 && dx < 5 && dy < 5) {
                dfs(dx, dy, depth + 1, str + arr[dx][dy]);
            }
        }
    }
}
