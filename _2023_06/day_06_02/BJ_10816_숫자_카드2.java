package com.ssafy._2023_06.day_06_02;

import java.util.*;
import java.io.*;

public class BJ_10816_숫자_카드2 {
    static int arr[], find[], visited[], answer;
    static HashMap<Integer, Integer> map;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        find = new int[M];
//        System.out.println(Arrays.toString(arr));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            answer = 0;
            visited = new int[N];
            find[i] = binarySearch(0, arr.length - 1, target);
        }

        for (int i : find) {
            System.out.print(i + " ");
        }
    }

    public static int binarySearch(int s, int e, int target) {
        int start = s;
        int end = e;

//        System.out.println(target);

        while(start <= end) {
            int mid = (start + end) / 2;
            // 숫자를 찾았다면,
            if (arr[mid] == target) {
                if (visited[mid] == 0) {
                    visited[mid] = 1;
//                    System.out.println("start : " + start + ", end : " + end + ", mid: " + mid);
//                    System.out.println(arr[mid] + ", " + target);
//                    System.out.println("======================");
                    answer++;
//                    System.out.println("앞쪽 찾기");
                    binarySearch(0, mid - 1, target);
//                    System.out.println("뒤쪽 찾기");
                    binarySearch(mid + 1, e, target);
                } else {
                    return 0;
                }
                break;

            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}

// 1, 2, 3, 4, [5], 6, 7, 8