package com.example.quicksort;

/**
 * 利用递归实现快速排序：
 * 快速排序：一种由冒泡排序演进而来的排序算法，使用分治的思想来提高算法性能，优化算法的时间复杂度。
 * <p>
 * 快速排序的实现（双边循环法）：以升序排序为例。
 * 首先定义一个基准元素pivot，这个基准元素可以从数组中随机获取，然后将获取到的元素和数组中的第一个元素交换位置，交换之后将数组的第一个元素作为基准元素。当然也可以直接将数组的第一个元素作为基准元素。
 * 定义好基准元素之后，定义两个指针left、right。left指针指向数组的第一个元素，right指针指向数组的最后一个元素。
 * 指针指好之后，就可以开始循环比较数组中的元素了：
 * ①：首先从right指针开始从后向前比较，如果当前right指针所指的元素大于等于基准元素pivot，则right指针向左移动一位，
 * 否则如果right指针所指的元素小于基准元素pivot，则right指针停止移动，换left指针开始移动。
 * ②：换到left指针之后，left指针开始从前向后比较，如果当前left指针所指的元素小于等于基准元素pivot，
 * 则left指针向右移动一位，否则如果left指针所指的元素大于基准元素pivot，则left指针停止移动。
 * ③：left指针和right指针都停止移动之后，将left指针所指的元素和right指针所指的元素进行交换。
 * ④：交换之后，right指针从当前所指位置重新开始向左移动，如果当前right指针所指的元素大于等于基准元素pivot，
 * 则right指针向左移动一位，否则如果right指针所指的元素小于基准元素pivot，则right指针停止移动，换left指针开始移动。
 * ⑤：换到left指针之后，left指针从当前所指位置开始继续从前向后比较，如果当前left指针所指的元素
 * 小于等于基准元素pivot，则left指针向右移动一位，否则如果left指针所指的元素大于基准元素pivot，则left指针停止移动。
 * ⑥：left指针和right指针都停止移动之后，将left指针所指的元素和right指针所指的元素进行交换。
 * ⑦：交换完成后，继续第四步④的逻辑，然后不断循环，循环的过程中left指针不断右移，right指针不断左移，
 * 总有一个位置，left指针和right指针能够重合，当left指针和right指针重合之后，说明一次比较已经结束了，
 * 此时将指针所指的元素和基准元素pivot相互交换位置。交换位置后，数组被基准元素分为零部分。
 * 基准元素之前的元素都小于基准元素，基准元素之后的元素都大于基准元素。
 * 然后对基准元素两边的元素分别采用上述方法继续比较，继续排序，直至新的基准元素分割后的数组无法再细分，说明此时数组中的元素已经有序。
 *
 * <p>
 * 快速排序的实现（单边循环法）：以升序排序为例。
 * 单边循环法，顾名思义，就是只从数组的一边进行循环比较。区别于双边循环法的从两边进行循环比较。
 * 单边循环法的实现如下：
 * ①：首先还是同双边循环法一样，选取一个基准元素pivot。
 * ②：定义好了基准元素pivot之后，再定义一个mark指针，该指针指向数组的第一个元素的位置。
 * mark指针之前的区域为小于基准元素的区域。基准元素pivot和指针mark都定义好之后，就要开始循环比较了。
 * ③：首先从数组的第二个元素开始，依次和基准元素比较，如果该元素大于等于基准元素，则让第三个元素和基准元素比较，
 * 否则如果第二个元素小于基准元素，则先让mark指针左移一位，因为小于基准元素的数据区域又多了一个元素。
 * 然后让新遍历到的元素和mark指针所指的元素进行交换，因为新遍历的元素属于小于基准元素的区域。
 * ④：交换完成之后，让数组从当前遍历到的位置开始继续向后遍历，如果遍历到的元素大于等于基准元素，则数组继续向后遍历。
 * mark指针在当前位置保持不动。否则如果遍历到的元素小于基准元素，则先让mark指针左移一位，然后让当前遍历到的元素和mark指针所指的元素进行交换。
 * ⑤：这一不断的向后遍历，比较，数组中的所有元素都遍历完成后，让mark指针所指的元素和基准元素进行交换。
 * 交换之后，mark指针之前的区域为小于基准元素的区域，mark指针之后的部分为大于基准元素的区域。
 * <p>
 * 对于基准元素前后的两个数据区域再分别采用上述方法进行遍历、比较、交换，直至新的基准元素两边的数据区域无法再划分，则此时的数组就是有序的。
 */
public class QuickSort {

    /**
     * 升序排序（双边循环法）
     *
     * @param array      待排序的数组
     * @param startIndex 数组的起始角标
     * @param endIndex   数组的尾角标
     */
    public static void ascQuickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = ascPartition(array, startIndex, endIndex);
        //根据基准元素的位置，将数组分成两部分，然后分而治之。基准元素位置之前的元素都小于基准元素，基准元素之后的元素都大于基准元素。
        ascQuickSort(array, startIndex, pivotIndex - 1);
        ascQuickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 计算并获取基准元素的位置（双边循环法）
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 返回新的基准元素的位置，此位置将数组分为左右两部分，基准元素位置之前的部分为小于基准元素的部分，基准元素位置之后的部分为大于基准元素的部分。
     */
    private static int ascPartition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && array[right] >= pivot) {
                right--;//如果right指针所指的元素大于等于基准元素pivot，则right指针左移，否则right指针停止移动，换left指针开始移动。
            }
            while (left < right && array[left] <= pivot) {
                left++;//如果left指针所指的元素小于等于基准元素pivot，则left指针右移，否则left指针停止移动，并对left指针所指的元素和right指针所指的元素进行数据交换。
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
     * @param startIndex 数组的起始角标
     * @param endIndex   数组的尾角标
     */
    public static void descQuickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = descPartition(array, startIndex, endIndex);
        descQuickSort(array, startIndex, pivotIndex - 1);
        descQuickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 计算并获取基准元素的位置（双边循环法）
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 返回新的基准元素的坐标
     */
    private static int descPartition(int[] array, int startIndex, int endIndex) {
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
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = ascendingPartition(array, startIndex, endIndex);
        ascendingQuickSort(array, startIndex, pivotIndex - 1);
        ascendingQuickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 计算并返回基准元素的位置（单边循环法）
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 返回新的基准元素的位置
     */
    private static int ascendingPartition(int[] array, int startIndex, int endIndex) {
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
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = descendingPartition(array, startIndex, endIndex);
        descendingQuickSort(array, startIndex, pivotIndex - 1);
        descendingQuickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 计算并返回新的基准元素的位置（单边循环法）
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 返回新的基准元素的位置
     */
    private static int descendingPartition(int[] array, int startIndex, int endIndex) {
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
