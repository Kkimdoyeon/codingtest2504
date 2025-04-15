package main.java.algo.ct.M4_1;

import java.util.*;
import java.io.*;

public class BOJ_18258 {

    static Deque<Integer> queue = new LinkedList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int X = Integer.parseInt(command.split(" ")[1]);
                queue.add(X);
            }
            else if (command.equals("pop")) {
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
            else if (command.equals("empty")) {
                if (queue.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else if (command.equals("front")) {
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.peek()).append("\n");
            }
            else if (command.equals("back")) {
                if (queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.peekLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
