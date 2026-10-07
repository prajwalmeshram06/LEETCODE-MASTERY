class Solution {

    static long mergeSort(int[] arr, int[] temp, int low, int high) {
        long count = 0;
        if (low >= high) {
            return count;
        }

        int mid = low + (high - low) / 2;

        count +=  mergeSort(arr, temp, low, mid);
        count += mergeSort(arr, temp, mid + 1, high);

        count += merge(arr, temp, low, mid, high);

        return count;
    }

    static long merge(int[] arr, int[] temp, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = low;
        long count = 0;
        // while(i <= mid && j <= high) {
        //     if((long)arr[i] > arr[j] * 2L) {
        //         count += mid - i + 1;
        //         i++;
        //     } else {
        //         j++;
        //     }
        // } 
        while (i <= mid && j <= high) {
            if ((long) arr[i] > 2L * arr[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        i = low;
        j = mid + 1;
        while (i <= mid && j <= high) {
            

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                
            }
        }

        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        
        for (i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        long count = mergeSort(nums, temp, 0, nums.length - 1);
        return (int)count;
    }
}