package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764_듣보잡_S4 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> hearX = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++)
            hearX.add(br.readLine());

        for (int i = 0; i < M; i++) {
            String check = br.readLine();
            if (hearX.contains(check))
                result.add(check);
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
