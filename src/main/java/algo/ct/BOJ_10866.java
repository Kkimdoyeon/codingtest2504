package main.java.algo.ct;

import java.io.*;
import java.util.*;

public class BOJ_10866 {
    static Deque<Integer> deque = new LinkedList<>();
    //static Deque<Integer> deque = new ArrayDeque<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("push_front")) {
                int X = Integer.parseInt(cmd.split(" ")[1]);
                deque.addFirst(X);
            }
            else if (cmd.startsWith("push_back")) {
                int X = Integer.parseInt(cmd.split(" ")[1]);
                deque.addLast(X);
            }
            else if (cmd.equals("pop_front")) {
                if (deque.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(deque.removeFirst()).append("\n");
            }
            else if (cmd.equals("pop_back")) {
                if (deque.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(deque.removeLast()).append("\n");
            }
            else if (cmd.equals("size"))
                sb.append(deque.size()).append("\n");
            else if (cmd.equals("empty")) {
                if (deque.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else if (cmd.equals("front")) {
                if (deque.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(deque.getFirst()).append("\n");
            }
            else if (cmd.equals("back")) {
                if (deque.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(deque.getLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
