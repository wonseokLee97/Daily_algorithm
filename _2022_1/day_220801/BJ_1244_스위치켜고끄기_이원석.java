package com.ssafy._2022_1.day_220801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기_이원석 {
    static int flag = 0;
    static int cnt = 1;
    static int origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] switches = new int[n];
        int std = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        for (int index = 0; index < std; index++) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int swt = Integer.parseInt(st.nextToken());
            origin = swt;
            flag = 0;
            cnt = 1;
            validate(sex, swt - 1, n - 1, switches);

        }

        for (int i = 0; i < n; i++) {
            System.out.print(switches[i] + " ");
            // 20개가 넘으면 cut
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void validate(int sex, int swt, int n, int[] switches) {
        if (swt > n) {
            return;
        }
        // 남자일 경우
        if (sex == 1) {
            // 해당 스위치를 변환 후
            if (switches[swt] == 1) {
                switches[swt] = 0;
            } else {
                switches[swt] = 1;
            }
            // 해당 스위치의 배수만큼 recursion
            validate(sex, (swt + 1) + origin - 1, n, switches);


        } else { // 여자일 경우
            // 해당 스위치 인덱스의 양 옆이 범위를 벗어나지 않는다면
            if ((swt - cnt >= 0) & (swt + cnt <= n)) {
                // 대칭이라면
                if (switches[swt - cnt] == switches[swt + cnt]) {
                    // 스위치 변환 앞
                    if (switches[swt - cnt] == 1) {
                        switches[swt - cnt] = 0;
                        switches[swt + cnt] = 0;
                    } else {
                        switches[swt - cnt] = 1;
                        switches[swt + cnt] = 1;
                    }
                    cnt++;
                    validate(sex, swt, n, switches);

                } else { // 대칭이 아니라면 현재 스위치만 변경후 return
                    flag = 1;
                    if (switches[swt] == 1) {
                        switches[swt] = 0;
                    } else {
                        switches[swt] = 1;
                    }
                    return;
                }
            }
        }

        if ((sex == 2) && (flag == 0)) {
            flag = 1;
            if (switches[swt] == 1) {
                switches[swt] = 0;
            } else {
                switches[swt] = 1;
            }
        }
        return;
    }
}

//7
//0 1 1 1 0 0 0
//6
//1 1
//2 2
//1 1
//1 2
//2 1
//2 1

// 0 1 1 1 0 0 0
// 1 0 0 0 1 1 1 -
// 1 1 0 0 1 1 1 -
// 0 0 1 1 0 0 0 -
// 0 1 1 0 0 1 0 -
// 1 1 1 0 0 1 0 -
// 0 1 1 0 0 1 0