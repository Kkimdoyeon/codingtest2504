package main.java.algo.ct.M4_3;

import java.io.*;
import java.util.*;

// 자주 나오는 단어 먼저
// 길이가 긴 단어 먼저
// 사전 순

public class BOJ_20920_영단어암기는괴로워_S3 {
    static int N, M;
    static HashMap<String, Integer> set = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cmd = br.readLine();
        N = Integer.parseInt(cmd.split(" ")[0]);
        M = Integer.parseInt(cmd.split(" ")[1]);

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if (key.length() >= M)
                set.put(key, set.getOrDefault(key, 0) + 1);
        }

        List<String> wordList = new ArrayList<>(set.keySet());

        Collections.sort(wordList, (a, b) -> {
            int freqA = set.get(a);
            int freqB = set.get(b);

            if (freqA != freqB)
                return freqB - freqA; // 빈도 내림차순
            else if (a.length() != b.length())
                return b.length() - a.length(); // 길이 내림차순
            else
                return a.compareTo(b); // 사전순 오름차순
        });

        // 정렬된 단어들을 출력
        StringBuilder sb = new StringBuilder();
        for (String str : wordList) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}
