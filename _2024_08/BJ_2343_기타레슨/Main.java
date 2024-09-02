package com.ssafy._2024_08.BJ_2343_기타레슨;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 강의의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이의 수
        int[] arr = new int[N];

        // 블루레이 크기의 최소값
        int s = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s = Math.max(s, arr[i]);
        }


        // 블루레이 크기의 최대값
        int e = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            e += arr[i];
        }

        while (s <= e) {
            // 블루레이 크기
            int m = (s + e) / 2;
            int cnt = 0;
            int before = arr[0];
            int total = before;

            for (int i = 1; i < N; i++) {
                // 블루레이의 최소 크기를 넘지 않는다면
                if (total + arr[i] <= m) {
                    total += arr[i];
                    continue;
                }

                // 블루레이의 최소 크기를 넘는다면
                cnt++;
                before = arr[i];
                // 블루레이의 개수 증가
                total = before;
            }

            if (total <= m) {
                cnt++;
            }
            // 마지막 블루레이의 total 이 m 초과인 경우
            // m으로 블루레이를 담지못하는 경우가 생긴다.
            // 따라서 m을 높여야함.
//            else {
//                s = m + 1;
//                continue;
//            }


            // 블루레이의 개수가 M보다 같거나 작으면
            if (cnt <= M) {
                e = m - 1;
                ans = m;
            } else {
                s = m + 1;
            }
        }

        System.out.println(ans);
    }
}

// M개의 블루레이를 만들 수 있는 m의 최소값을 찾아라 (Lower Bound - s)
// m  14  15  16  17  18  19 ...
// c   5   4   4   3   3   3

// N: 9 - 강의의 수
// M: 3 - 블루레이의 수
// 1 2 3 4 5 6 7 8 9

// 가능한 블루레이 크기중 최소를 출력한다.
// m: 블루레이
//

// 1,000,000,000// 1,000,000,000