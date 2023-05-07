package com.ssafy._2023_05.day_05_01;

public class PG_네트워크 {

    // 자기 자신과의 연결은 제외한다.
    // 다음 노드와 연결되어 있고, <i to j>
    // 아직 방문하지 않았다면,

    // 1 -> 2 -> x (o)
    // 1 -> 3 (x)
    // 2 -> 3

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3, new int[][] {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}}));
    }
}

// 1. 노드별로 (1, 2, 3 ...) 방문여부를 확인하여 탐색을 시작한다.
// 2. 한 번 탐색을 시작하면 네트워크로 간주한다. (answer++)
// 3. dfs 탐색을 시작하면 해당 노드는 방문 처리한다.
// 4. 해당 노드 i를 기준으로 다음 노드 j가
// 4-1. 자기 자신과의 연결은 제외하고,
// 4-2. 다음 노드와 연결되어 있고, <i to j>
// 4-3. 아직 방문하지 않았다면,
// 5. 다음 탐색(dfs) 로 들어간다.
// 6. 더 이상 연결 노드를 찾을 수 없을 때 까지 탐색하며 방문처리를 한다.
// 7. 다음 노드 i들 중, 이전의 탐색 중에서 아직 방문하지 않은 노드를 탐색한다.
// 8. 그렇게 되면, 연결된 네트워크의 개수를 구할 수 있다.

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 노드 방문 여부
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            // 방문하지 않은 노드만 탐색한다. (이미 연결된 노드들은 제외)
            if (visited[i] == 0) {
                dfs(computers, i);
//                System.out.println(Arrays.toString(visited));
                answer++;
            }
        }

        return answer;
    }

    static int visited[];

    void dfs(int[][] computers, int i) {
        visited[i] = 1;

        // 노드의 개수만큼 탐색한다.
        for (int j = 0; j < computers.length; j++) {
            // 연결되지 않았거나, 자신의 노드거나 이미 방문했다면 pass
            if (i == j || visited[j] == 1 || computers[i][j] == 0) {
//                System.out.println(i + ", " + j);
                continue;
            }

            // 조건을 만족하는 다음 노드를 방문한다.
            dfs(computers, j);
        }

        return;
    }
}
