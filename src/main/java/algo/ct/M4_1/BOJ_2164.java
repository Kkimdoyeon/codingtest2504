package main.java.algo.ct.M4_1;

import java.io.*;
import java.util.*;

public class BOJ_2164 {
    static int N;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        sb.append(queue.poll());
        System.out.print(sb);
    }
}
