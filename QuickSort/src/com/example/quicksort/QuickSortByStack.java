package com.example.quicksort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 利用栈结构实现快速排序
 * 使用栈结构实现的快速排序和使用递归实现的快速排序，两者的不同点主要在于排序方法中。而两种方式获取基准元素位置的xxxPartition()方法是相同的。
 * 下列几个排序方法中的逻辑完全相同，只要搞懂一个，其余的也就全都懂了。之所以每个方法都重复的敲一遍，纯粹是为了孰能生巧。
 */
public class QuickSortByStack {

    /**
     * 升序排序（双边循环法）
     *
     * @param array      待排序的数组
     * @param startIndex 数组的起始下标
     * @param endIndex   数组的结束下标
     */
    public static void ascQuickSort(int[] array, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        Map<String, Integer> rootRange = new HashMap<>();
        rootRange.put("startIndex", startIndex);
        rootRange.put("endIndex", endIndex);
        quickSortStack.push(rootRange);
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = ascPartition(array, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 计算并获取基准元素的位置（双边循环法）
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 返回新的基准元素在数组中的位置
     */
    public static int ascPartition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }

    /**
     * 降序排序（双边循环法）
     *
     * @param array      待排序的数组
     * @param startIndex 数组的起始下标
     * @param endIndex   数组的结束下标
     */
    public static void descQuickSort(int[] array, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        Map<String, Integer> rootRange = new HashMap<>();
        rootRange.put("startIndex", startIndex);
        rootRange.put("endIndex", endIndex);
        quickSortStack.push(rootRange);
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = descPartition(array, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 计算并获取基准元素的位置（双边循环法）
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 返回新的基准元素在数组中的位置
     */
    public static int descPartition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && array[right] <= pivot) {
                right--;
            }
            while (left < right && array[left] >= pivot) {
                left++;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }

    /**
     * 升序排序（单边循环法）
     *
     * @param array      待排序的数组
     * @param startIndex 数组的起始下标
     * @param endIndex   数组的结束下标
     */
    public static void ascendingQuickSort(int[] array, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        Map<String, Integer> rootRange = new HashMap<>();
        rootRange.put("startIndex", startIndex);
        rootRange.put("endIndex", endIndex);
        quickSortStack.push(rootRange);
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = ascendingPartition(array, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 计算并获取基准元素的位置（单边循环法）
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 返回新的基准元素在数组中的位置
     */
    public static int ascendingPartition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
                int temp = array[i];
                array[i] = array[mark];
                array[mark] = temp;
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    /**
     * 降序排序（单边循环法）
     *
     * @param array      待排序的数组
     * @param startIndex 数组的起始下标
     * @param endIndex   数组的结束下标
     */
    public static void descendingQuickSort(int[] array, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        Map<String, Integer> rootRange = new HashMap<>();
        rootRange.put("startIndex", startIndex);
        rootRange.put("endIndex", endIndex);
        quickSortStack.push(rootRange);
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = descendingPartition(array, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 计算并获取基准元素的位置
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 返回新的基准元素在数组中的位置
     */
    public static int descendingPartition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] > pivot) {
                mark++;
                int temp = array[i];
                array[i] = array[mark];
                array[mark] = temp;
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

}
