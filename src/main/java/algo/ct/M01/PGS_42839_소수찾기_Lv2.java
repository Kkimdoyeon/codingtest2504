package algo.ct.M01;

import java.util.*;

class PGS_42839_소수찾기_Lv2 {
    static HashSet<Integer> set = new HashSet<>(); // 중복된 정답 없이 관리하기 위해
    static char[] arr; // 종이조각
    static boolean[] visited;
    public int solution(String numbers) {
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++)
            arr[i] = numbers.charAt(i);

        dfs("", 0);

        return set.size();
    }

    public void dfs(String str, int depth) {
        int num;

        if (str != "") {
            num = Integer.parseInt(str);
            if (isPrime(num))
                set.add(num);
        }

        if (depth == arr.length) return;

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(str + arr[i], depth + 1);
            visited[i] = false; // 백트래킹
        }
    }

    public boolean isPrime(int num) {
        if (num == 0 || num == 1)
            return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}