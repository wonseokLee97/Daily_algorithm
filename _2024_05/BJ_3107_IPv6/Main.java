package com.ssafy._2024_05.BJ_3107_IPv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String IPv6 = br.readLine();

        // 8자리
        String[] split_arr = IPv6.split(":");

        // 분리한 문자열을 모두 넣어주는데, 8자리를 반드시 채워야 하기 때문에
        // 크기가 8인 문자형 배열로 맞춰줘야 한다. ex) ::, 1::, ::1 같은 경우 배열의 크기가 8이 안됨
        String[] split = new String[8];
        Arrays.fill(split, "");

        // 0 0 1 2 3 4 5 6 7

        int fflag = 0;
        int iidx = 0;
        for (int i = 0; i < split_arr.length; i++) {
            if (split_arr[i].equals("")) {
                if (fflag == 0) {
                    fflag = 1;
                    split[iidx] = split_arr[i];
                    iidx++;
                }

                continue;
            }

            split[iidx] = split_arr[i];
            iidx++;
        }


        int cnt = 0;
        // 빈 문자열이 아닌 경우 IP 주소가 있으므로 cnt 증가
        for (String ip : split) {
            if (!ip.equals("")) cnt++;
        }

        // (8-cnt) 의 개수 == 0000의 개수
        // cnt 의 개수 == 일반적인 IP 주소

        int flag = 0;
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < 8; i++) {
            String ip = split[i];

            // :로 문자열을 분리했는데 공백인 경우 ::를 사용했다고 판단
            // :: 콜론 두 개의 경우 한 번만 사용되기 때문에 flag 로 판별
            if (ip.equals("")) {
                if (flag == 0) {
                    flag = 1;

                    // 0000 의 개수만큼 채워준다.
                    for (int j = 0; j < 8 - cnt; j++) {
                        // idx 는 IP가 채워진 횟수이다.
                        // "0000"이 추가되어도 + 1
                        // "abcd"가 추가되어도 + 1
                        idx++;
                        sb.append("0000");

                        if (idx != 8) {
                            sb.append(":");
                        }
                    }
                }
                continue;
            }

            // 일반적인 IP 주소의 경우 반드시 4자리이므로 4자리 - 길이 만큼 0을 추가해주자.
            for (int j = 0; j < 4 - ip.length(); j++) {
                sb.append("0");
            }
            sb.append(ip);

            if (idx++ != 7) {
                sb.append(":");
            }
        }
        System.out.println(sb);
    }
}

// 2001:db8:85a3::8a2e:370:7334
// 2001:db8:85a3:0:0:8a2e:370:7334

// 0으로만 이루어져 있는 그룹의 경우, 그 중 "한 개 이상" 연속된 그룹을 하나 골라
// 콜론 2개로 바꿀 수 있다.

// ::1
// ip가 공백인 경우 ::가 있다는 의미이다.
// : 단위로 끊었을 때 n개가 있다면? 8-n개 만큼 0000이 있다는 뜻
// ex) 6개가 있다면 2개 만큼 있고,
//     1개가 있다면 7개 만큼 있다.
// 마지막에만 :를 붙여주고, 가장 마지막 인덱스만 안붙여줌

// ::가 있다는 것은
// 8개가 있어야 하는데 1개만 있다..

// 25:
// 09:
// 1985:
// aa:
// 091:
// 4846:
// 374:
// bb

// 1. 각 그룹의 앞자리의 0의 전체 또는 일부를 생략 할 수 있다.
// 위의 IPv6을 축약하면, 다음과 같다

// 2. 만약 0으로만 이루어져 있는 그룹이 있을 경우 그 중 한 개 이상
// 연속된 그룹을 하나 골라 콜론 2개(::)로 바꿀 수 있다.