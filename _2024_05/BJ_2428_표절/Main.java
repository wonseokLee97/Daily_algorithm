package com.ssafy._2024_05.BJ_2428_표절;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 0 부터 N-1번째 값 까지 비교조건이 맞는 최대 길이의 idx를 찾아야 함.
        // ex) i를 기준으로 비교 조건을 충족하지 못할 때 까지 = 이전 비교 조건이 최대 길이 비교가능한 길이
        for (int i = 0; i < N - 1; i++) {
            int s = i;
            int e = N - 1;
            int get = -1;

            while (s <= e) {
                int mid = (s + e) / 2;
//                System.out.println(s + ", " + e +", " + mid);

                if (arr[i] * 10 >= arr[mid] * 9) {
                    get = mid;
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

            if (get != -1) {
                ans += get - i;
            }
        }


        System.out.println(ans);
    }
}

// 4 3 2 1
// 5
// 1 1 1 1 1
// s   m   e - ok
// s e m     - ok
//


// s ..... mid ..... e
// s ... e mid .....

// 따라서, (Fi, Fj) 쌍을 검사해야 하는데,
// 이때, i≠j이고,
// size(Fi) ≤ size(Fj)이면서,
// size(Fi) ≥ 0.9 × size(Fj)인 쌍만 검사하려고 한다.