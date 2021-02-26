package com.example.bubblesort;

/**
 * 冒泡排序：冒泡排序是一种基础的比较排序，以升序排序为例：
 * 首先从数组的第一个元素开始，让第一个元素和第二个元素比较，如果第一个元素大于第二个元素，则第一个元素和第二个元素交换位置，否则就保持不变。
 * 然后让数组的第二个元素和第三个元素比较，如果第二个元素大于第三个元素，则第二个元素和第三个元素交换位置。否则就保持不变。
 * 如此循环的比较下去，等第一轮循环结束之后，数组中的最大值就出现在了数组的末尾。
 * <p>
 * 然后开始第二轮比较，第二轮比较依旧是从数组的第一个元素开始比较。但是第二轮比较就不需要比较数组中的所有元素了，
 * 因为经过第一轮的比较，数组末尾的最后一个值已经是数组中的最大值了，所以它就没必要再参与比较了。
 * 这也是内循环判断条件j < array.length - 1 - i在末尾要减去i的原因。
 * <p>
 * 等第二轮比较结束之后，数组中第二大的值就会出现在数组的倒数第二个位置上。如此不断的循环下去，等循环array.length - 1轮之后，数组就变成有序的了。
 * <p>
 * 冒泡排序中外循环用来控制循环的轮数，内循环用来控制数组中需要参与比较的元素个数。
 */
public class BubbleSort {

    /**
     * 升序排序：按元素从小到大排列
     *
     * @param array 要排序的数组
     */
    public static void ascSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //声明一个变量，用来判断当前数组中的元素是否已经是有序的了，默认为true，表示是有序的。
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    //如果在比较的过程中数组中的元素发生了交换操作，则说明数组仍旧是无序的，那就继续循环比较
                    isSorted = false;
                }
            }
            //如果在比较过程中数组中的元素没有出现交换的操作，则证明数组已经是有序的了，此时直接跳出循环，比较结束。
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 降序排序：按元素从大到小排列
     *
     * @param array 要排序的数组
     */
    public static void descSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param array  要交换元素位置的数组
     * @param index1 元素1的角标
     * @param index2 元素2的角标
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
