package com.example.bubblesort;

import java.util.Arrays;

public class BubbleSortTest {

    public static void main(String[] args) {
        final int[] array = {3, 2, 9, 1, 0, 5, 4, 6, 7, 8, 3};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        BubbleSort.ascSort(array);
        System.out.println("升序排序后：");
        System.out.println(Arrays.toString(array));
        BubbleSort.descSort(array);
        System.out.println("降序排序后：");
        System.out.println(Arrays.toString(array));
    }

}
