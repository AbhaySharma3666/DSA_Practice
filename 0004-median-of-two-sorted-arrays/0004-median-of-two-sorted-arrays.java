
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int num1Size = nums1.length;
        int num2Size = nums2.length;

        int[] arr = new int[num1Size + num2Size];

        // Copy nums1
        for (int i = 0; i < num1Size; i++) {
            arr[i] = nums1[i];
        }

        // Copy nums2
        for (int i = 0; i < num2Size; i++) {
            arr[num1Size + i] = nums2[i];
        }

        // Selection Sort
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        int mid = arr.length / 2;

        // Even length
        if (arr.length % 2 == 0) {
            return (arr[mid - 1] + arr[mid]) / 2.0;
        }

        // Odd length
        return arr[mid];
    }
}
