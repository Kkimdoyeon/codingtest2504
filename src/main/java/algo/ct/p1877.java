package main.java.algo.ct;

import java.util.*;

class p1877 {
    public boolean solution(int[] arr) {
        boolean answer = true;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if ((i+1 != arr[i]))
                answer = false;
        }

        return answer;
    }
}