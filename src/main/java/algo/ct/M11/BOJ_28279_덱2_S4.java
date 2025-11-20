package algo.ct.M11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_28279_덱2_S4 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new LinkedList<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1)
                deque.addFirst(String.valueOf(Integer.parseInt(st.nextToken())));
            if (cmd == 2)
                deque.addLast(String.valueOf(Integer.parseInt(st.nextToken())));
            if (cmd == 3) {
                if (deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.pollFirst());
            }
            if (cmd == 4){
                if (deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.pollLast());
            }
            if (cmd == 5)
                System.out.println(deque.size());
            if (cmd == 6) {
                if (deque.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            if (cmd == 7) {
                if (!deque.isEmpty())
                    System.out.println(deque.peekFirst());
                else
                    System.out.println(-1);
            }
            if (cmd == 8) {
                if (!deque.isEmpty())
                    System.out.println(deque.peekLast());
                else
                    System.out.println(-1);
            }
        }

    }
}
