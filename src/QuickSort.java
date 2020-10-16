class QuickSort {
  public static void main(String argu[]) {
         int nums[] = {87,9,123,45,6,58,65,7,111};
         QuickSort quickSort = new QuickSort();
         int nums1[] = {5,3,1,2,4,6,8,10};
         quickSort.print(nums);
         quickSort.sort(nums, 0, nums.length - 1);
         quickSort.print(nums);
         
         quickSort.print(nums1);
         quickSort.sort(nums1, 0, nums1.length - 1);
         quickSort.print(nums1);
    }

    void print(int nums[]) {
        for (int i1: nums) {
            System.out.print(i1 + "  ");
        }
        System.out.println();
    }
    void sort(int nums[], int low, int high) {
        if (low > high) {
            return;
        }
        int pivot = partition(nums, low, high);
        sort(nums, pivot + 1, high);
        sort(nums, low, pivot - 1);
    }
    int partition(int nums[], int low, int high) {
        int i = low;
        int j = high + 1;
        while(i < j) {
            while (i < high && nums[++i] < nums[low]);
            while (j > low && nums[--j] > nums[low]);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
