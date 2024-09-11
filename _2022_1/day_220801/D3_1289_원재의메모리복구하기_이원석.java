package com.ssafy._2022_1.day_220801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1289_원재의메모리복구하기_이원석 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        System.out.println(T);
        for (int t = 1; t < T + 1; t++) {
            char[] get_data = br.readLine().toCharArray();
            System.out.println("#" + t + " " + recovery(get_data));
            cnt = 0;
        }

    }
    public static int recovery(char[] get_data) {
        int flag = 0;
        for (int index = 0; index < get_data.length; index++) {
            if (flag == 1) {
                if (get_data[index] == '1') {
                    get_data[index] = '0';
                } else {
                    get_data[index] = '1';
                }
                continue;
            }

            if (get_data[index] == '1') {
                // 0으로 초기화
                get_data[index] = '0';
                flag = 1;
            }
        }
        if (flag == 0) {
            return cnt;
        }

        cnt++;
        return recovery(get_data);
    }
}
