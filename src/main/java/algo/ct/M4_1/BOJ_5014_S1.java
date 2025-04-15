package main.java.algo.ct.M4_1;

import java.io.*;
import java.util.*;
public class BOJ_5014_S1 {
    static int F, S, G, U, D;
    static boolean[] visited;

    // F는 건물 총 층 수
    // S는 강호가 현재 있는 층 수
    // G는 강호가 가려는 층 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        int result = bfs();

        if (result == -1)
            System.out.println("use the stairs");
        else
            System.out.println(result);
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>(); // 선입선출
        queue.offer(new int[]{S, 0});
        visited[S] = true; // 같은 층 수 방문 방지

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 배열 꺼내기
            int floor = current[0];
            int count = current[1];

            if (floor == G) // 도착했다면 현재 횟수 리턴
                return count;

            int up = floor + U;
            int down = floor - D;

            if (up <= F && !visited[up]) {
                visited[up] = true;
                queue.offer(new int[]{up, count+1});
            }

            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                queue.offer(new int[]{down, count+1});
            }
        }

        return -1;
    }
}
