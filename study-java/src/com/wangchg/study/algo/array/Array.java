package com.wangchg.study.algo.array;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/7/5
 */
public class Array {
    /**
     * 定义整型数据data保存数据
     */
    public int[] data;

    /**
     * 定义数组长度
     */
    private int n;

    /**
     * 定义数组中实际个数
     */
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        //一开始一个数都没有所以是0
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        //数组空间已满
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }
        //位置不合法
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index + 1; i >= count; ++i) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
    }
}
