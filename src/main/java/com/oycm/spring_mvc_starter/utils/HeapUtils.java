package com.oycm.spring_mvc_starter.utils;

import java.util.Arrays;

/**
 * @author ouyangcm
 * create 2024/3/26 16:36
 */
public class HeapUtils {

    public static void main(String[] args) {

        int[] ints = {0, 10, 9, 8, 4, 1, 3, 0};
        Heap heap = new Heap(ints, ints.length - 1);
        heap.heapify();
        printHeap(heap.queue);
        System.out.println(ints[7 >> 1]);
        System.out.println(ints[3]);
        int i = 3;
        System.out.println(ints[i++]);
        System.out.println(ints[++i]);
    }


    public static void printHeap(int[] ints){
        int high = 0;
        int temp = ints.length - 1;
        while ((temp = temp >> 1) >= 1){
            high++;
        }
        StringBuilder str = new StringBuilder();
        for (int i = high; i >= 0 ; i--) {
            int start = (int) Math.pow(2, i);
            int end = Math.min(ints.length - 1, (((int) Math.pow(2, i + 1)) -1));
            for (int j = start; j <= end; j++) {
                str.append(ints[j] + " ");
            }
            str.append("\n");
        }
        System.out.println(str);
    }
}

class Heap{

    int size;

    int[] queue;

    Heap(int[] queue){
        this.queue = queue;
    }

    Heap(int[] queue, int size){
        this.size = size;
        this.queue = queue;
    }

    /**
     * 往堆中添加元素(小顶堆)
     * @param e 元素
     */
    void add(int e){
        if (size == queue.length - 1){
            // 扩容
            queue = Arrays.copyOf(queue, 2 * queue.length);
        }
        queue[++size] = e;
        fixedUp(size);
    }

    private void fixedUp(int k){
        // 写法一
        while (k > 1){
            int j = k >> 1;
            if (queue[j] <= queue[k]){
                // 小顶堆 i表示堆中数组下标,则满足queue[i] <= queue[2*i] queue[i] <= queue[2*i + 1]
                // 其中j表示的就是i
                break;
            }
            int temp = queue[k];
            queue[k] = queue[j];
            queue[j] = temp;
            k = j;
        }
        // 写法二
        while (k > 1 && queue[k >> 1] > queue[k]){
            int temp = queue[k >> 1];
            queue[k >> 1] = queue[k];
            queue[k] = temp;
            k = k >> 1;
        }
    }

    void heapify(){
        for (int i = size/2; i >= 1; i--) {
            fixedDown(i);
        }
    }

    private void fixedDown(int k){
        int j;
        while ((j = k << 1) <= size && j > 0){
            if (j < size && queue[j] > queue[j + 1]){
                j++;
            }
            // queue[j] 为最小
            if (queue[k] <= queue[j]){
                break;
            }
            int temp = queue[j];
            queue[j] = queue[k];
            queue[k] = temp;
            k = j;
        }
    }
}
