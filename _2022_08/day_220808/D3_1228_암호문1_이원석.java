package com.ssafy.day_220808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D3_1228_암호문1_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cmd = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmd; i++) {
                if (st.nextToken().charAt(0) == 'I') {
                    int X = Integer.parseInt(st.nextToken());
                    int Y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < Y; j++) {
                        list.add(X++, Integer.valueOf(st.nextToken()));
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i) + " ");
            }
            System.out.println(sb);
        }
    }
}

// I 1 5 400905 139831 966064 336948 119288
// I 8 6 436704 702451 762737 557561 810021 771706
// I 3 8 389953 706628 552108 238749 661021 498160 493414 377808
// I 13 4 237017 301569 243869 252994
// I 3 4 408347 618608 822798 370982
// I 8 2 424216 356268
// I 4 10 512816 992679 693002 835918 768525 949227 628969 521945 839380 479976