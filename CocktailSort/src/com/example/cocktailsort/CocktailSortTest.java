package com.example.cocktailsort;

import java.util.Arrays;

public class CocktailSortTest {

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 5, 6, 7, 8, 0, 20};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        CocktailSort.ascSort(array);
        System.out.println("升序排序后：");
        System.out.println(Arrays.toString(array));
        CocktailSort.descSort(array);
        System.out.println("降序排序后：");
        System.out.println(Arrays.toString(array));
    }

}
