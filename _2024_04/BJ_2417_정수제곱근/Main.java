package com.ssafy._2024_04.BJ_2417_정수제곱근;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long s = 0;
        long e = (long) Math.pow(2, 63);
        long ans = 0;

        while (s <= e) {
            long mid = (s + e) / 2;
            long sqrt = (long) Math.pow(mid, 2);

            if (sqrt < N) {
                s = mid + 1;
            } else {
                e = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
