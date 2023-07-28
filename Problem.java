package com.ssafy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Game implements Comparable<Game> {

    long time;
    int totalTry;
    int totalRetry;

    public Game(long time, int totalTry, int totalRetry) {
        this.time = time;
        this.totalTry = totalTry;
        this.totalRetry = totalRetry;
    }

    @Override
    public String toString() {
        return "Game{" +
                "time=" + time +
                ", totalTry=" + totalTry +
                ", totalRetry=" + totalRetry +
                '}';
    }

    @Override
    public int compareTo(Game o) {
        // 도전 횟수가 적은 순서로 정렬
        if (this.totalTry != o.totalTry) {
            return Integer.compare(this.totalTry, o.totalTry);
        }

        // 재시도 횟수가 적은 순서로 정렬
        if (this.totalRetry != o.totalRetry) {
            return Integer.compare(this.totalRetry, o.totalRetry);
        }

        // 게임 시간이 짧은 순서로 정렬
        return Long.compare(this.time, o.time);
    }
}

public class Problem {

    static List<Integer> idx;
    static List<Character> bridge;
    static List<Game> record;

    public static void main(String[] args) throws IOException {
        // 메인 메서드에서 게임을 시작한다.
        playGame();
    }

    static void makeBridge(List<Integer> idx) {
        // 돌다리에 대한 정보를 저장하는 List
         bridge = new ArrayList<>();

        // 순서를 보장하지않기 위해 섞는다.
        Collections.shuffle(idx);

        // 총 20개의 강과 돌다리를 랜덤으로 배치하기 때문에,
        for (int i = 0; i < 20; i++) {
            int get = idx.get(i) / 10;

            // 0이면 돌
            if (get == 0) {
                bridge.add(i, 'O');
            }
            // 1이면 강
            else {
                bridge.add(i, '#');
            }
        }
    }

    static void playGame() throws IOException {
        // 20개의 인덱스를 0부터 19까지 초기화.
        idx = new ArrayList<>();
        record = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            idx.add(i);
        }

        int totalRetry = 0;
        int flag = 0;
        Scanner sc = new Scanner(System.in);

        // 다리를 건널 때 까지 게임을 실행한다.
        while (flag == 0) {
            // 게임 시작시간
            long startTime = System.currentTimeMillis();

            int totalTry = 1;
            int nowIdx = -1;

            makeBridge(idx);

            System.out.println("== 게임 시작! ==");

            while (true) {
                // 스페이스 바 또는 엔터를 입력받으면 다음 시도로 넘어간다.
                // 입력 구문을 주석처리하면, 게임이 자동으로 진행된다.
//                String next = sc.nextLine();

                // 랜덤의 1~4 사이의 주사위 값
                int randomDice = (int) (Math.random() * 10) % 4 + 1;
                nowIdx += randomDice;

                // 게임 상황 출력
                printGame(totalTry, randomDice, nowIdx);

                // 무사히 끝까지 다리를 건넌 경우
                if (nowIdx >= 20) {
                    flag = 1;
                    break;
                }

                // 다음으로 건넌곳이 강인 경우
                if (bridge.get(nowIdx) == '#') {
                    totalRetry++;
                    break;
                }

                totalTry++;
            }

            // 게임 종료시간
            long endTime = System.currentTimeMillis();
            long gameTime = (endTime - startTime) / 1000;
            double get = Math.random() * 100;

            record.add(new Game((int) (get % 60), totalTry, totalRetry));

            // 다리를 건너기까지의 소요 횟수
            System.out.println();
        }

        // 조건대로 정렬 (도전횟수와 재시도횟수와 게임시간이 짧은 것을 높은 순위로 두고 정렬)
        Collections.sort(record);


        // 결과를 파일에 저장
        try (FileWriter writer = new FileWriter("gameResult.txt", true)) {
            writer.write("\t\t\t도전 횟수\t재시도 횟수\t게임 시간\n");
            for (int i = 0; i < record.size(); i++) {
                Game game = record.get(i);
                writer.write((i + 1) + "\t\t\t" + game.totalTry + "\t\t\t" + game.totalRetry + "\t\t\t" + game.time + "s\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void printGame(int cnt, int randomDice, int nowIdx) {
        StringBuilder sb;

        System.out.println(cnt + ".  " + randomDice);
        sb = new StringBuilder();

        // 다리 출력
        for (char c : bridge) {
            sb.append(c);
        }
        System.out.println(sb);

        sb = new StringBuilder();

        // 현재 위치 출력
        for (int i = 0; i < bridge.size() + 4; i++) {
            if (i == nowIdx) {
                sb.append("^");
            } else {
                sb.append(" ");
            }
        }
        System.out.println(sb);
        System.out.println();
    }
}

//
//