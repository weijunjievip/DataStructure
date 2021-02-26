package com.example.cocktailsort;

import java.util.Arrays;

/**
 * 鸡尾酒排序：
 * 鸡尾酒排序是由冒泡排序衍生而来的一种排序方式，它的适用场景是数组中大部分元素都是有序排列的，只有一小部分元素在数组中是无序的情况。
 * 鸡尾酒排序的外循环控制循环的轮数，然后在外循环中嵌套两个内循环，
 * 第一个内循环从前往后遍历比较，第二个内循环从后往前遍历比较。
 * <p>
 * 它的排序方式是：首先从前往后遍历，一次遍历结束后数组中最大的值就出现在了数组的末尾。
 * 然后开始从后往前遍历，这一次遍历结束后数组中最小的元素就出现在了数组的第一个位置。到此一轮循环结束。
 * 然后开始第二轮循环，第二轮循环依旧是从前向后遍历，一次遍历结束后，数组中第二大的值就出现在了数组的倒数第二个位置。
 * 紧接着开始从后往前遍历，这一次遍历结束后数组中第二小的元素就出现在了数组的第二个位置。又一轮循环结束。
 * 如此循环，直至数组中元素都是有序的为止。
 */
public class CocktailSort {

    /**
     * 升序排序：数组中元素从小到大排列
     *
     * @param array 待排序的数组
     */
    public static void ascSort(int[] array) {
        int postLastExchangeIndex = 0;
        int preLastExchangeIndex = 0;
        int postSortBorder = array.length - 1;//从前向后循环比较时的有序边界，该边界之后的元素都是有序的
        int preSortBorder = 0;//从后先前循环比较时的有序边界，该边界之前的元素都是有序的。
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            for (int j = preSortBorder; j < postSortBorder; j++) {//从前往后开始循环比较
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorted = false;
                    postLastExchangeIndex = j;
                }
            }
            postSortBorder = postLastExchangeIndex;
            if (isSorted) {
                break;
            }

            isSorted = true;
            for (int j = postSortBorder; j > preSortBorder; j--) {//从后向前开始循环比较
                if (array[j] < array[j - 1]) {
                    swap(array, j - 1, j);
                    isSorted = false;
                    preLastExchangeIndex = j;
                }
            }
            preSortBorder = preLastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 降序排序：数组中的元素从大到小排列
     *
     * @param array 待排序的数组
     */
    public static void descSort(int[] array) {
        int preLastChangeIndex = 0;
        int preSortBorder = 0;
        int postLastChangeIndex = 0;
        int postSortBorder = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            for (int j = preSortBorder; j < postSortBorder; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorted = false;
                    postLastChangeIndex = j;
                }
            }
            postSortBorder = postLastChangeIndex;
            if (isSorted) {
                break;
            }

            isSorted = true;
            for (int j = postSortBorder; j > preSortBorder; j--) {
                if (array[j] > array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                    preLastChangeIndex = j;
                }
            }
            preSortBorder = preLastChangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param array  要交换元素的数组
     * @param index1 第一个元素在数组中的下标
     * @param index2 第二个元素在数组中的下标
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
