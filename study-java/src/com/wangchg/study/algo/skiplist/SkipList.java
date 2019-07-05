package com.wangchg.study.algo.skiplist;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/7/5
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    private Node head = new Node();
    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public class Node {
        private int data = -1;
        private Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", forwards=" + Arrays.toString(forwards) +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }
}
