package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드_S5 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr1[i]= Integer.parseInt(st.nextToken());
        Arrays.sort(arr1);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(arr1, target) >= 0)
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);
    }

//    // 직접 구현한 이분 탐색 메서드
//    public static boolean binarySearch(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//
//            if (arr[mid] == target)
//                return true;
//            else if (arr[mid] < target)
//                left = mid + 1;
//            else
//                right = mid - 1;
//        }
//
//        return false;
//    }
}

// HashSet으로 선언하면 시간 초과 안 나고 contains 쓰기가능
//public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    N = Integer.parseInt(br.readLine());
//    HashSet<Integer> set = new HashSet<>();
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    for (int i = 0; i < N; i++)
//        set.add(Integer.parseInt(st.nextToken()));
//
//    M = Integer.parseInt(br.readLine());
//    st = new StringTokenizer(br.readLine());
//    StringBuilder sb = new StringBuilder();
//
//    for (int i = 0; i < M; i++) {
//        int num = Integer.parseInt(st.nextToken());
//        if (set.contains(num))
//            sb.append("1 ");
//        else
//            sb.append("0 ");
//    }
//
//    System.out.println(sb);
//}