package com.ssafy._2023._2023_07.day_07_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_6987_월드컵 {

    static int visited[], arr[][], flag;
    static List<List<Integer>> list;
    static List<int[]> match;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        list = new ArrayList<>();

        // 승패, 무무, 패승
        match = new ArrayList<>();
        match.add(new int[]{2, 0});
        match.add(new int[]{1, 1});
        match.add(new int[]{0, 2});

        visited = new int[6];

        comb(0, 0);

        for (int t = 0; t < 4; t++) {
            arr = new int[6][3];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            flag = 0;
            dfs(0);

            // 조건이 예상되지 않는 경우
            if (flag == 1) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int cnt) {

        // 모든 팀 매칭의 경우를 순회했다면,
        if (cnt == list.size()) {
            flag = 1;

            for (int[] match : arr) {
                for (int m : match) {
                    if (m != 0) {
                        // 조건이 틀린경우
                        flag = 0;
                        break;
                    }
                }
            }
            return;
        }

        List<Integer> team = list.get(cnt);
        int i = team.get(0);
        int j = team.get(1);
        for (int[] m : match) {
            int x = m[0];
            int y = m[1];

            // i팀이 x하는 경우(승,패,무)가 0보다 크고, j팀이 y하는 경우(승,패,무)가 0보다 큰 경우에만
            if (arr[i][x] > 0 && arr[j][y] > 0) {
                // 해당 경기를 치루기 때문에 1씩 감소시킨다.
                arr[i][x] -= 1;
                arr[j][y] -= 1;
                dfs(cnt + 1);
                arr[i][x] += 1;
                arr[j][y] += 1;
            }
        }
    }

    static void comb(int cnt, int start) {
        if (cnt == 2) {
            List<Integer> team = new ArrayList<>();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 1) {
                    team.add(i);
                }
            }

            list.add(team);
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            comb(cnt + 1, i + 1);
            visited[i] = 0;
        }
    }
}



// 조건 1. 경기 횟수의 총합이 5
// 조건 2.
// 나라	승	무	패
// A	 5	0	0
// B	 3	0	2
// C	 2	0	3
// D	 0	0	5
// E	 4	0	1
// F	 1	0	4
// total
//       15 0   15

//나라	승	무	패
//A 	5	0	0
//B	    4	0	1
//C	    2	2	1
//D	    2	0	3
//E	    1	0	4
//F	    0	0	5
// total
//      14  2   14

//나라	승	무	패
//A	    5	0	0
//B	    3	1	1
//C	    2	1	2
//D	    2	0	3
//E	    0	0	5
//F	    1	0	4
// total
//      13  2   15

