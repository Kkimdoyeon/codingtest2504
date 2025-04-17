package main.java.algo.ct.M4_3;

import java.io.*;
import java.util.*;

public class BOJ_16917_양념반후라이드반_B2 {
    static int A, B, C, X, Y;
    static int min = Integer.MAX_VALUE;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int max = Math.max(X, Y);
        for (int i = 0; i <= max; i++) {
            int a = Math.max(0, X-i);
            int b = Math.max(0, Y-i);
            min = Math.min(min, A*a + B*b + C*i*2);
        }

        System.out.println(min);
    }
}
