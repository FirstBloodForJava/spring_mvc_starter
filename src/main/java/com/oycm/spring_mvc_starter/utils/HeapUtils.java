package com.oycm.spring_mvc_starter.utils;

/**
 * @author ouyangcm
 * create 2024/3/26 16:36
 */
public class HeapUtils {

    public static void main(String[] args) {

        int[] ints = {0, 10, 9, 8, 4, 1, 3, 0};
        Heap heap = new Heap(ints);
        heap.heapify();
        printHeap(heap.queue);
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
        this.size = queue.length - 1;
        this.queue = queue;
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
