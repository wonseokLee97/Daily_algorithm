package com.ssafy._2023._2023_08.day_08_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + k - 1];
        int[] choice = new int[d + 1];

        int max_val = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k - 1; i++) {
            arr[N + i] = arr[i];
        }

//        System.out.println(Arrays.toString(arr));

        // 이미 무료 초밥을 먹었다고 치자.
        int cnt = 0;
        int s = 0;
        int e = 0;
        choice[arr[0]] = 1;

        while (s < N) {
            // 연속된 숫자가 k 미만인 경우
            if (e - s < k - 1) {
                e++;
                choice[arr[e]]++;
            } else { // 연속된 숫자가 k 이상인 경우
//                System.out.println(Arrays.toString(choice));
//                StringBuilder sb = new StringBuilder();
//                System.out.println(s + ", " + e);
                for (int i = 1; i < choice.length; i++) {
                    if (choice[i] >= 1) {
//                        sb.append(i + " ");
                        cnt++;
                    } else if (i == c) {
                        cnt++;
                    }
                }

//                System.out.println(sb + ", " + cnt);
//                System.out.println();
                max_val = Math.max(max_val, cnt);
                cnt = 0;

                choice[arr[s]]--;
                s++;
            }
        }

        System.out.println(max_val);
    }
}

// 7 9 7 30 2 7 9 25 / 7 9 7 30
//   [      ]
//       [      ]
//          [      ]
// [7, 9, 7, 30, 2, 7, 9, 25, 7, 9, 7]

// 중복되지 않는 최장길이를 구해볼까

//[7, 9, 7, 30, 2, 7, 9, 25, 7, 9, 7]
