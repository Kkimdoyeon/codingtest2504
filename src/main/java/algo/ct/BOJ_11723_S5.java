package main.java.algo.ct;

import java.io.*;
import java.util.*;

public class BOJ_11723_S5 {
    static List<Integer> list = new ArrayList<>();
    static int M, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            String a = command.split(" ")[0];

            if (a.startsWith("add")) {
                b = Integer.parseInt(command.split(" ")[1]);
                if (!list.contains(b))
                    list.add(b);
            }
            if (a.startsWith("remove")) {
                b = Integer.parseInt(command.split(" ")[1]);
                if (list.contains(b))
                    list.remove(Integer.valueOf(b));
            }
            if (a.startsWith("check")) {
                b = Integer.parseInt(command.split(" ")[1]);
                if (list.contains(b))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            if (a.startsWith("toggle")) {
                b = Integer.parseInt(command.split(" ")[1]);
                if (list.contains(b))
                    list.remove(Integer.valueOf(b));
                else
                    list.add(b);
            }
            if (a.equals("all")) {
                list.clear();
                for (int j = 1; j <= 20; j++)
                    list.add(j);
            }
            if (a.equals("empty"))
                list.clear();
        }

        System.out.print(sb);
    }
}
