package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1644_소수의연속합_G3 {
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        int left = 0, right = 0;
        int sum = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N) answer++;
                sum -= primes.get(left++);
            }
            else {
                if (right == primes.size()) break;
                sum += primes.get(right++);
            }
        }

        System.out.println(answer);
    }
}
