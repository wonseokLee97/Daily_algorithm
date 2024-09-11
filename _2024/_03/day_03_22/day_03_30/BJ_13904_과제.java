package com.ssafy._2024._03.day_03_22.day_03_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Work {
    int d;
    int w;
    int idx;

    public Work(int d, int w, int idx) {
        this.d = d;
        this.w = w;
        this.idx = idx;
    }
}

public class BJ_13904_과제 {
    static int max_day;
    static PriorityQueue<Work> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>(new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                if (o1.d == o2.d) {
                    return o2.w - o1.w;
                }

                return o1.d - o2.d;
            }
        });

        Work[] arr = new Work[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            max_day = Math.max(max_day, d);
//            pq.offer(new Work(d, w));
            arr[i] = new Work(d, w, i + 1);
        }

        Arrays.sort(arr, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o2.w - o1.w;
            }
        });

        int[] visited = new int[N];
        int total = 0;
        for (int i = max_day; i >= 1; i--) {
            for (int j = 0; j < N; j++) {
                if (visited[j] == 1) {
                    continue;
                }

                if (i <= arr[j].d) {
//                    System.out.println(max_day + ", " + arr[j].d);
                    visited[j] = 1;
//                    System.out.println(arr[j].idx);
                    total += arr[j].w;
                    break;
                }
            }
        }

        System.out.println(total);
    }
}

// 1 000 000

// 4 60
// 2 50
// 3 30
// 4 40
// 1 20
// 4 10
// 6 5


// 가장 많은 점수를 얻을 수 있도록 과제를 ㅅ행
// 마감일이 지난 과제는 점수 X

// 5-4-2-1-7

// 3 30 - 5
// 2 50 - 4
// 4 60 - 2
// 4 60 - 1
// 6 5  - 7

// 4 60
// 4 40
// 1 20
// 2 50
// 3 30
// 4 10
// 6 5