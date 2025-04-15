package main.java.algo.ct.M4_2;

import java.util.*;
import java.io.*;

public class BOJ_14888_S1 {
    static int N;
    static ArrayList<Integer> array = new ArrayList<>();
    static int[] symbol = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    // 백트래킹 메서드: 현재 연산한 깊이(depth)와 현재까지 계산된 결과(current)
    static void dfs(int depth, int current) {
        // 숫자 N개로 만들 수 있는 연산은 N - 1번이므로, 종료 조건
        // (((3 연산자 4) 연산자 5) 연산자 6)
        if (depth == N - 1) {
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (symbol[i] > 0) { // 해당 연산자가 남아있다면
                symbol[i]--; // 연산자 사용

                int next = 0;
                if (i == 0) next = current + array.get(depth + 1);
                else if (i == 1) next = current - array.get(depth + 1);
                else if (i == 2) next = current * array.get(depth + 1);
                else {
                    if (current < 0 )
                        next = -(-current / array.get(depth + 1));
                    else
                        next = current / array.get(depth + 1);
                }

                dfs(depth + 1, next); // 다음 숫자와 함께 dfs 재귀 호출

                symbol[i]++; // 백트래킹 (사용한 연산자 복구) -> 다음 경우의 수에서 써야되니까 ;;
            }
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            array.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            symbol[i] = Integer.parseInt(st.nextToken());

        dfs(0, array.get(0));

        System.out.println(max);
        System.out.println(min);
    }
}
