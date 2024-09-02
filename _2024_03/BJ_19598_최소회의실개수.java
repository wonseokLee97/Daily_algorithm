package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meet {
    int S;
    int T;

    Meet(int S, int T) {
        this.S = S;
        this.T = T;
    }
}

public class BJ_19598_최소회의실개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Meet[] arr = new Meet[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            arr[i] = new Meet(S, T);
        }

        Arrays.sort(arr, new Comparator<Meet>() {
            @Override
            public int compare(Meet o1, Meet o2) {
                if (o1.S == o2.S) {
                    return o1.T - o2.T;
                }

                return o1.S - o2.S;
            }
        });

        pq.offer(arr[0].T);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i].S) {
                pq.poll();
            }

            pq.offer(arr[i].T);
        }

        System.out.println(pq.size());
    }
}

// 0                40
//    5  10
//          15  30
