package com.example.quicksort;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] array = {4, 7, 3, 5, 6, 2, 8, 1};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("升序排序后");
        QuickSortByStack.ascQuickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        array = new int[]{4, 7, 3, 5, 6, 2, 8, 1};
        System.out.println("降序排序后：");
        QuickSortByStack.descQuickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        System.out.println("================================");

        int[] arr = {4, 7, 3, 5, 6, 2, 8, 1};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        System.out.println("升序排序后");
        QuickSortByStack.ascendingQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{4, 7, 3, 5, 6, 2, 8, 1};
        System.out.println("降序排序后：");
        QuickSortByStack.descendingQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
