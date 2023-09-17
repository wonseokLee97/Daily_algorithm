package com.ssafy.Trie;

import java.util.*;

class Node {
    public HashMap<Character, Node> children;
    public boolean isEndOfrWord;

    public Node() {
        children = new HashMap<>();
        isEndOfrWord = false;
    }
}

public class Trie {
    private Node root;

    // SingleTon
    private static Trie trie = new Trie();
    private static List<String> list = new ArrayList<>();
    private Trie() {
        this.root = new Node();
    }

    public static Trie getInstance() {
        return trie;
    }
    // ==========

    // 문자열을 Trie 트리에 삽입한다.
    public void insert(String word) {
        insert(this.root, word);
    }

    private void insert(Node node, String word) {
        if (word.length() == 0) {
            node.isEndOfrWord = true;
            return;
        }

        char c = word.charAt(0);
        Node child = node.children.get(c);

        if (child == null) {
            child = new Node();
            node.children.put(c, child);
        }

        insert(child, word.substring(1));
    }


    public String search (String word) {
        StringBuilder sb = new StringBuilder();
        // 루트노드를 기반으로 탐색한다.
        return search(this.root, word, sb);
    }

    private String search (Node node, String word, StringBuilder sb) {
        if (word.length() == 0) {
            return node.isEndOfrWord ? sb.toString() : null;
        }

        // 찾으려는 문자열의 맨 앞 문자.
        char c = word.charAt(0);

        // 해당 문자를 가진 자식 노드를 가져온다.
        Node nowNode = node.children.get(c);

        // 노드의 자식이 없다면? 해당 문자열을 찾을 수 없다.
        if (nowNode == null) {
            return null;
        }

        return search(nowNode, word.substring(1), sb.append(c));
    }

    // 자동완성
    public List<String> autoComplete(String prefix) {
        Node nowNode = this.root;

        // ex) abo
        for (char c : prefix.toCharArray()) {
            Node childNode = nowNode.children.get(c);

            if (childNode == null) {
                return new ArrayList<>();
            }

            // a - b - o 순으로 다음 노드들을 저장한다
            nowNode = childNode;
        }

        return searchStartWith(nowNode, new StringBuilder(prefix));
    }

    public List<String> searchStartWith(Node node, StringBuilder prefix) {
        List<String> results = new ArrayList<>();

        // 만약, prefix와 일치하는 단어가 있을 경우
        if (node.isEndOfrWord == true) {
            results.add(prefix.toString());
        }

        // entrySet()은 해당 HashMap의 key와 value값을 가져오는 함수
        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            // 가져온 문자를 추가하자
            prefix.append(entry.getKey());

//            results.addAll(searchStartWith(entry.getValue(), prefix));
            List<String> result = searchStartWith(entry.getValue(), prefix);
            for (String r : result) {
                results.add(r);
            }

            prefix.deleteCharAt(prefix.length() - 1);
        }

        return results;
    }






    @Override
    public String toString() {
        Node root = trie.root;

        for (Character c : root.children.keySet()) {
            StringBuilder sb = new StringBuilder();
            dfs(root.children.get(c), sb.append(c));
        }

        return list.toString();
    }

    public void dfs(Node nowNode, StringBuilder sb) {
        if (nowNode.children.isEmpty()) {
            list.add(sb.toString());
            return;
        }

        if (nowNode.isEndOfrWord) {
            list.add(sb.toString());
        }

        for (Character nc : nowNode.children.keySet()) {
            // 원본 sb는 그대로 두고, sb + nc 만 넘겨야함
            sb.append(nc);
            dfs(nowNode.children.get(nc), sb);
            sb.delete(sb.toString().length() - 1, sb.toString().length());
        }
    }
}

