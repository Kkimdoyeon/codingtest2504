package main.java.algo.ct.M4_3;

import java.util.*;
import java.io.*;

public class BOJ_2252_줄세우기_G3 {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b); // a -> b
            indegree[b]++; // b의 진입 차수 증가
        }

        // 위상 정렬
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0)
                queue.offer(i); // 진입 차수가 0이면 큐에 삽입

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0)
                    queue.offer(next);
            }
        }

        System.out.println(sb);
    }
}
