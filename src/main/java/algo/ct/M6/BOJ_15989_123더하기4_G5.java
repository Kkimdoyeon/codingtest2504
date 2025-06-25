package main.java.algo.ct.M6;

import java.util.*;
import java.io.*;

public class BOJ_15989_123더하기4_G5 {
    static int T;
    static int n[];
    static int dp[][] = new int[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = new int[T];
        for (int i = 0; i < T; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }

    }

}
