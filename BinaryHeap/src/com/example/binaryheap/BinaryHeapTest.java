package com.example.binaryheap;

import java.util.Arrays;

public class BinaryHeapTest {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        BinaryHeap.upAdjustInSmallHeap(arr);
        System.out.println(Arrays.toString(arr));

        int[] array = {7, 1, 3, 10, 5, 2, 8, 9, 6};
        BinaryHeap.buildSmallestHeap(array);
        System.out.println(Arrays.toString(array));

        int[] maxArray = {10, 9, 8, 7, 5, 6, 2, 3, 1, 4, 11};
        BinaryHeap.upAdjustInMaximalHeap(maxArray);
        System.out.println(Arrays.toString(maxArray));

        int[] maxArr = {7, 1, 3, 10, 5, 2, 8, 9, 6};
        BinaryHeap.buildMaximalHeap(maxArr);
        System.out.println(Arrays.toString(maxArr));
    }

}
