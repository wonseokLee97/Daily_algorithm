package com.ssafy.day_220802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1208_Flatten_이원석 {
    static int cnt = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t < 11; t++) {
            int dump = Integer.parseInt(br.readLine());
            int[] dump_list = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++) {
                dump_list[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(dump_list);

            dumper(dump_list, dump);
            System.out.printf("#%d %d\n",t, result);
            cnt = 0;
            result = 0;
        }
    }


    public static void dumper(int[] dl, int dump) {
        if (cnt == dump) {
            result = dl[99] - dl[0];
            return;
        }

        // 상자 옮기기
        dl[99] -= 1;
        dl[0] += 1;
        Arrays.sort(dl);
        cnt++;

        dumper(dl, dump);
        return;
    }
}
//2
//5 8 3 1 5 6 9 9 2 2 4

//2 2 3 3 4 5 5 6 8 9 9



// 4