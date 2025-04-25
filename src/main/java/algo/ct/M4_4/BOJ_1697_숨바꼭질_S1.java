package main.java.algo.ct.M4_4;

import java.io.*;
import java.util.*;

public class BOJ_1697_숨바꼭질_S1 {
    static int N, K;
    static int[] visited = new int[100001]; // 방문 배열: 시간 저장용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

        System.out.println(visited[K]);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0; // 시작 위치는 시간 0

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) return;

            int[] moves = {now - 1, now + 1, now * 2};
            for (int next: moves) {
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[now] + 1; // 도착 시간 저장
                    queue.add(next); // 그 위치도 탐색하기 위해 큐에 추가
                }
            }
        }
    }
}
