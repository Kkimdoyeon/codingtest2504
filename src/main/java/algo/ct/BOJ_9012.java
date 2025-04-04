package main.java.algo.ct;

import java.io.*;
import java.util.*;

public class BOJ_9012 {
    static int N, K;
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++)
            queue.add(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < K-1; i++)
                queue.add(queue.poll());

            result.add(queue.poll());
        }

        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i != result.size()-1)
               sb.append(", ");
        }

        sb.append(">");
        System.out.print(sb);
    }
}
