package com.tancy.algorithm.sort;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/6/19 16:56
 * @description 堆排序
 */
public class HeapSort {

    public Integer[] heap = new Integer[100];

    public int len = 0;


    public static void main(String[] args) {

        int[] nums = {4, 1, 5, 6, 3, 2};
        sort(nums);

//        sort1(nums);
    }



    public static void sort(int[] nums) {
        int right = nums.length / 2 - 1;
        // 构建大顶堆
        for (int i = right; i >= 0; i--) {
            toDown(nums, i, nums.length - 1);
        }
        System.out.println(Arrays.toString(nums));

        // 与堆顶元素交换，下沉操作，重新排序
        right = nums.length - 1;
        while (right > 0) {
            swap(nums, 0, right--);
            toDown(nums, 0, right);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void toDown(int[] nums, int index, int tail) {
        int current = index, child = (current + 1) * 2 - 1;
        while (child < tail) {
            if (child + 1 < tail && (nums[child] < nums[child + 1])) {
                child++;
            }
            if (nums[current] >= nums[child]) break;
            swap(nums, current, child);
            current = child;
            child = (current + 1) * 2 - 1;
        }
    }

    public static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    /**
     * 上浮：将 index 位置的节点和父节点比较，大于父节点则与其交换
     *
     * @param index
     */
    public void toUp(int index) {
        int current = index;
        while (current > 0 && heap[current] > heap[(current + 1) / 2 - 1]) {
            swap(current, (current + 1) / 2 - 1);
            current = (current + 1) / 2 - 1;
        }
    }

    /**
     * 下沉：将 index 位置的节点和子节点比较，小于子节点则与其交换
     *
     * @param index
     */
    public void toDown(int index) {
        int current = index;
        while ((current + 1) * 2 - 1 < len) {
            int left = (current + 1) * 2 - 1;
            if ((left + 1) < len && heap[left] < heap[left + 1]) {
                left++;
            }
            if (heap[current] >= heap[left]) break;
            swap(current, left);
            current = left;
        }
    }

    public void insert(int val) {
        heap[len++] = val;
        toUp(len - 1);
    }

    public void deleteMax() {
        heap[0] = heap[len - 1];
        heap[--len] = null;
        toDown(0);
    }

    public void swap(int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }



    public static void sort1(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

}
