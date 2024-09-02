package com.ssafy._2024_06.BJ_12015_가장긴증가하는부분수열2;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        LIS[0] = arr[0];
        int len = 1;
        for (int i = 1; i < N; i++) {
            System.out.println(Arrays.toString(LIS) + ", " + len);
            // 이전의 가장 큰 값보다 큰 경우
            if (LIS[len - 1] < arr[i]) {
                LIS[len] = arr[i];
                len++;
            } else { // 대치할 위치를 찾자.
                int s = 0;
                int e = len;
                int key = 0;

                while (s <= e) {
                    int mid = (s + e) / 2;

                    if (LIS[mid] >= arr[i]) {
                        key = mid;
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                }

                LIS[key] = arr[i];
            }
        }

        System.out.println(len);
    }
}


// 증가하는 부분 수열은 투포인터로 풀 수 없을듣ㅅ..?
// 10, 50, 20, 30, 40

// 10 10 20 20 30 50
// 10 20 10 30 20 50

// 10 20 30 50
// 10
// 10 20
// 10 20 10!
// 10 20 30
// 10 20 30 20!
// 10 20 30 50

// 새로운 값을 추가할 때, 이전의 가장 큰 값보다 작다면?
// 길이에 대한 이분탐색을 통해 대치할 인덱스를 찾아야함.

//10
//10 20 30 15 20 30 50 40 45 60
// 10 15 20 30 40 45 60