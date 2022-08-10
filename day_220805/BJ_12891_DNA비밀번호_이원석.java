package com.ssafy.day_220805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_12891_DNA비밀번호_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;

        // 입력받은 DNA 염기서열
        char[] DNA = br.readLine().toCharArray();
        HashMap<Character, Integer> dna = new HashMap<>(); // DNA 해시맵
        HashMap<Character, Integer> validate = new HashMap<>(); // 검증용 해시맵

        char[] ACGT = {'A', 'C', 'G', 'T'}; // 4종류의 DNA
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            // 입력받은 DNA 사용회수를 검증용 해시맵에 저장
            validate.put(ACGT[i], Integer.valueOf(st.nextToken()));
        }

        // DNA 해시맵을 초기화
        for (char c : ACGT) {
            dna.put(c, 0);
        }

        // P 길이의 부분문자열을 S 안에서 돌린다. 따라서 범위는 S - P + 1(index)
        for (int i = 0; i < S - P + 1; i++) {
            int flag = 0;

            // 시작
            if (i == 0) {
                // 부분문자열 생성
                for (int j = 0; j < P; j++) {
                    dna.put(DNA[j], dna.get(DNA[j]) + 1);
                }
            } else { // 가장 앞의 문자를 복원하고 마지막 문자를 추가하여 사용한다.
                dna.put(DNA[i + P - 1], dna.get(DNA[i + P - 1]) + 1);
                dna.put(DNA[i - 1], dna.get(DNA[i - 1]) - 1);
            }

            for (char c : ACGT) {
                // 최소 개수보다 더 많이 사용하지 않았다면,
                if (validate.get(c) > dna.get(c)) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}

// AAACCTGCCAA
// [CCTGG] ATTGCTATCT

//11 4
//AAACCTGCCAA
//1 1 1 0

// AAACCTGCCAA
// 1 1 1 0
// A C G T

// AAAC - [-2 0 1 0]
// AACC - [-1 -1 1 0]
// ACCT - [0 -1 1 -1]
// ...
// [0 0 0 -100]
