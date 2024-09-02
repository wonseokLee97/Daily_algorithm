package com.ssafy._2024_06.BJ_3151_합이0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 분류: 이분탐색, 조합론
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long cnt = 0;
        for (int idx = 0; idx < N; idx++) {
            // 만약, 현재값이 0보다 크다면, 이후의 s/e 값들은 모두 0보다 크다 == 0을 만들수 없다.
            if (arr[idx] > 0) break;
            int s = idx + 1;
            int e = N - 1;
            int fix = arr[idx];

            while (s < e) {
                int total = arr[s] + arr[e] + fix;

                if (total == 0) {
                    int l = 1;
                    int r = 1;

                    //  f s       e
                    // -9 3 3 3 3 3
                    // -9, 3, 3을 고르는 경우, arr[s] == arr[e]라면 5개중 2개를 고르는 조합이다.
                    if (arr[s] == arr[e]) {
                        int n = e - s + 1;
                        cnt += comb(n);
                        break;
                    }

                    // 현재 s와 같은 값의 개수를 구하자.
                    //  f s       e
                    // -8 3 3 5 5 5 와 같은 경우
                    // 나올수 있는 0의 가짓수는 -8을 고정하고, 3:2개, 5:3개
                    // 총 합 6개가 있다.

                    while (arr[s] == arr[s + 1]) {
                        s++;
                        l++;
                    }

                    // 현재 e와 같은 값의 개수를 구하자.
                    while (arr[e] == arr[e - 1]) {
                        e--;
                        r++;
                    }

                    cnt += l * r;
                }


                if (total > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }

        System.out.println(cnt);
    }

    static int comb(int n) {
        return n * (n - 1) / 2;
    }
}

// 그녀는 팀워크와 코딩 실력이 모두 적절한 팀을 만들기 위해,
// 세 팀원의 코딩 실력의 합이 0이 되는 팀을 만들고자 한다.

// 10
// s
// 2 -5 2 3 -4 7 -4 0 1 -6
//    e

// idx 한 개를 고정하고, 이외의 값들을 투 포인터로 탐색
//  f  s                 e
// -6 -5 -4 -4 0 1 2 2 3 7
//

// 100,000,000 O(4 * N^2)

//8
//-10 5 5 5 5 5 5 5

//6
//-8 3 3 5 5 5

