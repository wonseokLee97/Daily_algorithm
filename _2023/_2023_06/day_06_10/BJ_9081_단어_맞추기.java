package com.ssafy._2023._2023_06.day_06_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 시작 시간 7시 30분
// 종료 시간 9시 23분
// 기준의 순열 방식으로는 풀 수 없었다. (메모리 초과 및 시간초과)
// NextPermutation 을 활용하여 첫 단어의 다음 순열을 구해 시간을 줄일 수 있었다.

public class BJ_9081_단어_맞추기 {

    static char arr[];
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            arr = s.toCharArray();
            answer = "";

            np();

            System.out.println(answer);
        }
    }

    // 1. 순열에서 감소하는 부분을 찾자.
    // 2. 해당 부분을 기준으로 오른쪽에서 더 큰 요소를 찾자.
    // 3. 둘이 swap
    // 4. 해당 부분을 기준으로 오른쪽을 정렬하자.
    public static void np() {
        int N = arr.length;
        int idx = 0;

        for (int i = N - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                idx = i;
                break;
            }
        }

        // 감소하는 부분이 없으므로 다음 순열이 없다.
        if (idx == 0) {
            for (int i = 0; i < N; i++) {
                answer += arr[i];
            }

            return;
        } else {
            char tmp;

            for (int i = N - 1; i >= idx; i--) {
                if (arr[idx - 1] < arr[i]) {
                    tmp = arr[idx - 1];
                    arr[idx - 1] = arr[i];
                    arr[i] = tmp;
                    break;
                }
            }
        }

        Arrays.sort(arr, idx, N);

        for (int i = 0; i < N; i++) {
            answer += arr[i];
        }
    }
}


// B E E R

// D R I / N K
// D R K / N I
// D R K / I N