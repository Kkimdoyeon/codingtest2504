package main.java.algo.ct.M4_4;

import java.io.*;
import java.util.*;

public class BOJ_1181_단어정렬_S5 {
    static int N;
    static ArrayList<String> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (arr.contains(word))
                continue;
            else
                arr.add(word);
        }

        arr.sort(
                Comparator.comparingInt(String::length)     // 1. 먼저 길이순 정렬하고
                        .thenComparing(Comparator.naturalOrder()) // 2. 길이 같으면 알파벳순 정렬
        );


        for (String num : arr)
            System.out.println(num);

    }
}
