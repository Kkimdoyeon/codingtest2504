package algo.ct.M5_2;

import java.io.*;
import java.util.*;

public class BOJ_11779_최소비용구하기2 {
    static class Node implements Comparable<Node> {
        int city, cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);

        // 경로 역추적
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != 0; at = prev[at]) {
            path.add(at);
        }

        Collections.reverse(path);

        System.out.println(path.size());

        for (int city : path) {
            System.out.print(city + " ");
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 이미 더 짧은 경로로 방문했다면 무시
            if (dist[current.city] < current.cost) continue;

            for (Node next : graph[current.city]) {
                int newCost = dist[current.city] + next.cost;

                // 더 짧은 경로 발견 시 갱신
                if (dist[next.city] > newCost) {
                    dist[next.city] = newCost;
                    prev[next.city] = current.city;
                    pq.offer(new Node(next.city, newCost));
                }
            }
        }
    }
}
