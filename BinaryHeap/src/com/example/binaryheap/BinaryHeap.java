package com.example.binaryheap;

/**
 * 二叉堆
 */
public class BinaryHeap {

    /**
     * 最小堆中最后一个叶子节点的上浮调整（二叉堆中添加新元素时会用到）：让数组中最后一个元素，也就是二叉堆中的最后一个叶子节点上浮至适合自己的位置。
     * <p>
     * 上浮调整，让最后一个叶子节点的值和其当前父节点的值进行比较，
     * 如果父节点的值大于这个叶子节点的值，则父节点下沉，孩子节点上浮（孩子节点和父节点互换位置）。
     * 当孩子节点上浮之后，让上浮上来的这个孩子节点和它现在的父节点的值进行比较，
     * 如果它现在的父节点的值仍旧比它大，则它现在的父节点下沉，该孩子节点上浮，
     * 直至该孩子节点上浮至堆顶的位置，或上浮过程中遇到父节点的值比它小的情况时停止循环，调整完成。
     *
     * @param array 待调整的堆
     */
    public static void upAdjustInSmallHeap(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex]; //声明一个临时变量，用来存储堆中的最后一个元素
        while (childIndex > 0 && temp < array[parentIndex]) {
            //用父节点的值覆盖孩子节点的值，只做单向赋值，不进行交换，这样可以避免元素间做连续交换时所带来的时间和性能的开销
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[parentIndex] = temp;
    }

    /**
     * 下沉调整，如果父节点的值大于左右孩子节点中最小的一个，则父节点下沉到当前孩子节点的位置。
     * 父节点下沉到孩子节点的位置后，让下沉下来的节点作为新的父节点，然后获取该父节点的孩子节点（如果有的话，没有的话就结束循环）。
     * 获取到新的父节点和孩子节点之后，让新的父节点和它的孩子节点继续比较，如果新的父节点的值仍旧大于它的孩子节点的值的话，新的父节点继续下沉。
     * 按照上面的逻辑不断循环，直至下沉下来的新的父节点不再有孩子节点，或者下沉下来的新的父节点的值小于它的孩子节点的值为止，循环结束，调整完毕。
     *
     * @param array       待调整的堆
     * @param parentIndex 要下沉的父节点坐标
     * @param length      堆的有效大小
     */
    private static void downAdjustInSmallHeap(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            //如果有右孩子结点，并且右孩子结点的值小于左孩子结点的值，则定位到右孩子节点
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建最小二叉堆：从最后一个父节点开始，所有父节点的值大于孩子节点的值的父节点依次下沉。
     *
     * @param array 待调整的堆
     */
    public static void buildSmallestHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjustInSmallHeap(array, i, array.length);
        }
    }

    /**
     * 最大二叉堆中的最后一个叶子节点的上浮调整（二叉堆中添加新元素时会用到）
     *
     * @param array 待调整的堆
     */
    public static void upAdjustInMaximalHeap(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建最大二叉堆时父节点的下沉调整：如果父节点的值小于它的左右孩子节点中的最大值，则父节点下沉，孩子节点中拥有最大值的那个节点上浮。
     *
     * @param array       待调整的堆
     * @param parentIndex 要下沉的父节点坐标
     * @param length      堆的有效大小
     */
    private static void downAdjustInMaximalHeap(int[] array, int parentIndex, int length) {
        int childIndex = parentIndex * 2 + 1;
        int temp = array[parentIndex];
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建最大二叉堆：从最后一个叶子节点开始，让所有父节点的值小于孩子节点的值的父节点依次做下沉操作。
     *
     * @param array 待调整的堆
     */
    public static void buildMaximalHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjustInMaximalHeap(array, i, array.length);
        }
    }

}
