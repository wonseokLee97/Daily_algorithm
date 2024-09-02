package com.ssafy._2024_06.BJ_16564_히오스프로게이머;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long min = 0;
        long max = arr[N - 1];
        long result = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            for (long i : arr) {
                if (mid - i > 0) count += mid - i;
            }

            // 총합이 K보다 작거나 같다면.. mid 값을 증가시켜주자.
            if (count > K) {
                max = mid - 1;
            } else {
                result = mid;
                min = mid + 1;
            }
        }

        System.out.println(result);
    }

    static long bs(long K, long min, long max, long[] arr) {
        long result = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            for (long i : arr) {
                if (mid - i > 0) count += mid - i;
            }

            // 총합이 K보다 작거나 같다면.. mid 값을 증가시켜주자.
            if (count > K) {
                max = mid - 1;
            } else {
                result = mid;
                min = mid + 1;
            }
        }

        return result;
    }
}


// N개의 캐릭터
// 캐릭터  1, 2, 3 ... N
// 레벨   X1 X2 X3 .. Xn

//  1   2   3
// 10  20  15  ->  10  15  20
// 17  20  17
// +7  +0  +2
// s = 0, K = 10일 때
// mid = 5
//