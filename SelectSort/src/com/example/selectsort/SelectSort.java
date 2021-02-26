package com.example.selectsort;

/**
 * 选择排序
 * 选择排序的排序方式：以升序排序为例：
 * 首先从数组的第一个元素开始比较，那数组的第一个元素和第二个元素比较，如果第一个元素大于第二个元素，则互相交换位置，否则保持不变。
 * 然后继续拿数组的第一个元素和数组的第三个元素比较，如果第一个元素大于第三个元素，则互相交换位置，否则保持不变。
 * 。。。
 * 这样一轮比较下来，数组中最小的元素就出现在了数组的第一个位置上。
 * 然后开始第二轮比较，由于数组的第一个位置上已经是数组中的最小元素了，因此第二轮比较从数组的第二个元素开始。
 * 首先拿数组的第二个元素和第三个元素比较，如果第二个元素大于第三个元素，则互相交换位置，否则保持不变。
 * 然后继续拿数组的第二个元素和数组的第四个元素比较，如果第二个元素大于第四个元素，则互相交换位置。否则保持不变。
 * 。。。
 * 第二轮比较下来，数组中第二小的元素就出现在了数组的第二个位置上。
 * 。。。
 * <p>
 * 选择排序中，外循环控制比较的轮数，内循环控制数组中参与比较的元素个数。
 */
public class SelectSort {

    /**
     * 升序排序
     *
     * @param array 待排序的数组
     */
    public static void ascSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    /**
     * 降序排序
     *
     * @param array 待排序的数组
     */
    public static void descSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
