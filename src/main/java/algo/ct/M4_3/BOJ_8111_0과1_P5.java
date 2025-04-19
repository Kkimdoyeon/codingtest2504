package main.java.algo.ct.M4_3;

import java.io.*;
import java.util.*;

public class BOJ_8111_0과1_P5 {
    static class Node {
        String numStr; // 지금까지 만든 0과 1로 이루어진 숫자 문자열
        int remainder; // 이 숫자를 N으로 나눈 나머지

        Node(String numStr, int remainder) {
            this.numStr = numStr;
            this.remainder = remainder;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());

            if (N == 1) {
                System.out.println("1");
                continue;
            }

            boolean[] visited = new boolean[N];
            Queue<Node> queue = new LinkedList<>();

            // 시작 상태는 "1", 나머지는 1 % N
            queue.add(new Node("1", 1));
            visited[1] = true;

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                // 정답 조건
                if (now.remainder == 0) {
                    System.out.println(now.numStr);
                    break;
                }

                // 다음 숫자: 현재 문자열 + "0"
                int nextRemainder0 = (now.remainder * 10) % N;
                if (!visited[nextRemainder0]) {
                    visited[nextRemainder0] = true;
                    queue.add(new Node(now.numStr + "0", nextRemainder0));
                }

                // 다음 숫자: 현재 문자열 + "1"
                int nextRemainder1 = (now.remainder * 10 + 1) % N;
                if (!visited[nextRemainder1]) {
                    visited[nextRemainder1] = true;
                    queue.add(new Node(now.numStr + "1", nextRemainder1));
                }
            }
        }
    }
}
