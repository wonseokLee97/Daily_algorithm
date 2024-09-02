package com.ssafy._2023._2023_09.day_09_05;

import java.io.IOException;
import java.util.*;

public class BJ_1047_Z {
    static int cnt, arr[][], r, c, ans, flag;

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();

        s.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});

    }
}

class Solution {
    static HashMap<String, List<String>> map;
    static HashMap<String, List<String>> visited;
    static List<String> ans;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        map = new HashMap<>();
        visited = new HashMap<>();
        ans = new ArrayList<>();


        for (String[] t : tickets) {
            String from = t[0];
            String to = t[1];

            // 방문기록 생성
            if (visited.get(from) == null) {
                visited.put(from, new ArrayList<>());
            }
            if (visited.get(to) == null) {
                visited.put(to, new ArrayList<>());
            }

            if (map.get(from) == null) {
                map.put(from, new ArrayList<>());
                map.get(from).add(to);
            } else {
                map.get(from).add(to);
            }

            Collections.sort(map.get(from), (a , b) -> a.compareTo(b));
        }

        bfs("ICN");


        return answer;
    }

    static void bfs(String start) {
        Queue<String> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            String now_node = q.poll();
            List<String> list = map.get(now_node);

            if (list == null) {
                ans.add(now_node);
                break;
            }

            for (int i = 0; i < list.size(); i++) {
                String next_node = list.get(i);

                // 이미 해당 도시에서 방문했던 곳이라면 pass
                if (visited.get(now_node).contains(next_node)) {
                    continue;
                }

                ans.add(now_node);
                q.offer(next_node);
            }
        }
    }
}

// 2x2 행렬에서
// 1 2
// 3 4 순으로 순회하며 탐색한다.

// N = 3 , 8일때
// 8 -> 4 -> 2 까지 Divide
// 0,0 / 0,1 / 0,2 / 0,3
// 1,0 / 1,1 / 1,2 / 1,3