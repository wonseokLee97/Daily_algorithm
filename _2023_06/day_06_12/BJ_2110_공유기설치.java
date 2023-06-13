package com.ssafy._2023_06.day_06_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치 {

    static int arr[], N, C, answer, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = 0;

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        bs();
        System.out.println(answer - 1);
    }

    public static void bs() {
        // 길이에 대한 이분탐색
        int start = 1;
        int end = arr[N - 1] - arr[0] + 1;

        int mid;

        while (start < end) {
            // 최소 거리
            mid = (start + end) / 2;

            // 공유기를 설치할 수 있는 개수
            int cnt = 1;
            int start_x = arr[0];

            for (int i = 1; i < N; i++) {
                // arr[i]의 집에 start 에서 다음 지점까지 움직일 수 있는 경우..
                if (arr[i] - start_x >= mid) {
                    cnt++;
                    start_x = arr[i];
//                    System.out.print(arr[i] + " - ");
                }
            }
//            System.out.println();
//            System.out.println("cnt: "  + cnt + ", mid: " + mid);

            // 공유기를 C개 미만으로 설치한 경우 mid(최대거리)를 줄여야 함.
            // 그래야지 공유기 더 많이 설치함 ㅋㅋ
            if (cnt < C) {
                end = mid;
            } else { // mid 를 줄여야 함, start 를 줄이자.
                start = mid + 1;
//                answer = mid;
            }
        }

        answer = (start + end) / 2;
    }
}

// 집의 개수: N, 공유기 개수: C
// [1], [2], 3, [4], 5, 6, 7, [8], [9]

// 첫 번째 집을 기준으로, 최대 거리로 C 개의 공유기를 설치할 수 있는가?
//

// 그러니까, 이 문제는 가장 인접한 두 공유기 사이의 최대 거리를 구한다.
// 따라서 특정 간격(mid) 값이, 두 집 사이의 거리랑 같거나 클 때를 기준으로 해야지,
// 최대 거리이다.