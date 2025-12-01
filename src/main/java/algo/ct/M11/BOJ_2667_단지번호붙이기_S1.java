package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667_단지번호붙이기_S1 {
    static int N;
    static boolean[][] visited;
    static int[][] arr;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && (visited[i][j] == false)) {
                    int cnt = bfs(i, j);
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++)
            System.out.println(answer.get(i));
    }

    public static int bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int count = 1; // 단지 집 개수

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + nx[i];
                int nextY = curY + ny[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;
                if (arr[nextX][nextY] == 0) continue;

                q.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                count++;
            }
        }

        return count;
    }
}
