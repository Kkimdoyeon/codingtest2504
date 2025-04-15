package main.java.algo.ct.M4_3;

import java.io.*;

public class BOJ_16968_차량번호판1_B1 {
    static char[] arr;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cmd = br.readLine();
        int count = cmd.length();
        arr = cmd.toCharArray();// 문자 하나하나를 배열로 변환
        //System.out.println("배열: " + Arrays.toString(arr));

        int result = 1;
        for (int i = 0; i < count; i++) {
            if (arr[i] == 'd') {
                if ((i-1) >= 0 && arr[i-1] == 'd')
                    result *= 9;
                else
                    result *= 10;
            }
            else if (arr[i] == 'c') {
                if ((i-1) >= 0 && arr[i-1] == 'c')
                    result *= 25;
                else
                    result *= 26;
            }
        }

        System.out.println(result);
    }
}
