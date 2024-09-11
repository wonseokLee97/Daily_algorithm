package com.ssafy._2022_1.day_220816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Chemical implements Comparable<Chemical>{
    int min_val, max_val;

    public Chemical(int min_val, int max_val) {
        this.min_val = min_val;
        this.max_val = max_val;
    }
    //
    @Override
    public int compareTo(Chemical o) {
        return this.min_val != o.min_val ? this.min_val - o.min_val : this.max_val - o.max_val;
    }
}

public class JO_1828_냉장고_이원석 {
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Chemical> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        Chemical[] chemicals = new Chemical[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            chemicals[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(chemicals);
        solution(chemicals, chemicals[0].max_val);
        System.out.println(cnt);
    }

    public static void solution(Chemical[] list, int before_max) {

        for (int i = 1, size = list.length; i < size; i++) {
            // 이전의 최고온도가 지금의 최소온도보다 같거나 크다면, 온도범위를 공유한다.
            if (before_max >= list[i].min_val) {
                // 또한 이전의 최고온도가 지금의 최고온도보다 크다면,
                if (before_max > list[i].max_val) {
                    // 온도의 범위를 낮춘다.
                    before_max = list[i].max_val;
                }
                // 아니라면 continue
                continue;
            } else {
                cnt++;
                before_max = list[i].max_val;
            }
        }
    }
}

//4
//-15 5
//-15 10
//-12 30
//-21 -15

// -15       5
//             6           36
//               10                     73
//                     27       44


//4
//-15 5
//-10 36
//10 73
//27 44
