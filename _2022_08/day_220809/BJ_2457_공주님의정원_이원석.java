package com.ssafy.day_220809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Node implements Comparable<Node> {
    int start_day;
    int end_day;

    public Node(int start_day, int end_day) {
        this.start_day = start_day;
        this.end_day = end_day;
    }

    @Override
    public int compareTo(Node node) {
        if (this.start_day - node.start_day == 0) { // 시작하는 날이 같으면
            return node.end_day - this.end_day; // 끝나는 날을 기준으로 정렬
        }
        return this.start_day - node.start_day; // 아닐경우 시작일을 기준으로 정렬
    }
}

public class BJ_2457_공주님의정원_이원석 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int flower = 0;
        int flag = 1;
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] sum_days = new int[13];
        int[] year_of_day = new int[366];

        for (int i = 1; i < 13; i++) {
            sum_days[i] = sum_days[i - 1] + days[i];
        }

        for (int i = sum_days[2] + 1; i < sum_days[11] + 1; i++) {
            year_of_day[i] = 1;
        }


//      [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365]
        Queue<Integer> q = new LinkedList();
        int N = Integer.parseInt(br.readLine());
        Node[] tmp = new Node[N];


        for (int i = 0; i < N; i++) {
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            int s_month = Integer.parseInt(st.nextToken());
            int s_day = Integer.parseInt(st.nextToken());
            int e_month = Integer.parseInt(st.nextToken());
            int e_day = Integer.parseInt(st.nextToken());

            int start_val = sum_days[s_month - 1] + s_day;
            int end_val = sum_days[e_month - 1] + e_day;

            tmp[i] = new Node(start_val, end_val);
        }

        Arrays.sort(tmp);

        for (int i = 0; i < tmp.length; i++) {

        }
    }
}

// 105, 81, 78, 57, 55
// 105, 81, 78, 57

// 6.15 ~ 9.27
// 6.15 ~ 9.3
// 9.14 ~ 12.24
// 4.12 ~ 6.5
// 2.28 ~ 4.25