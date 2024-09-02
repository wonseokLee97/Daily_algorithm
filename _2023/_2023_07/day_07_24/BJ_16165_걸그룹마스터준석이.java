package com.ssafy._2023._2023_07.day_07_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16165_걸그룹마스터준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<String, List<String>> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int mCnt = Integer.parseInt(br.readLine());

            for (int j = 0; j < mCnt; j++) {
                String m = br.readLine();

                if (map.get(groupName) == null) {
                    List<String> members = new ArrayList<>();
                    members.add(m);
                    map.put(groupName, members);
                } else {
                    List<String> members = map.get(groupName);
                    members.add(m);
                    map.put(groupName, members);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // Quiz
        for (int i = 0; i < M; i++) {
            String who = br.readLine();
            int type = Integer.parseInt(br.readLine());

            // 멤버가 속한 팀의 이름을 출력
            if (type == 1) {
                for (String groupName : map.keySet()) {
                    List<String> members = map.get(groupName);

                    if (members.contains(who)) {
                        sb.append(groupName + "\n");
                        break;
                    }
                }

            }
            // 팀에 속한 멤버의 이름을 사전순으로 한 줄에 한 명씩 출력
            else {
                List<String> members = map.get(who);
                Collections.sort(members);

                for (String m : members) {
                    sb.append(m + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
