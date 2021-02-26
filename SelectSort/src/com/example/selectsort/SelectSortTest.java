package com.example.selectsort;

import java.util.Arrays;

public class SelectSortTest {

    public static void main(String[] args) {
        int[] array = {8, 2, 1, 0, 3, 4, 9, 6, 7, 5};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("升序排序后：");
        SelectSort.ascSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("降序排序后：");
        SelectSort.descSort(array);
        System.out.println(Arrays.toString(array));
    }

}
