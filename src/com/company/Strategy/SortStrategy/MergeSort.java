package com.company.Strategy.SortStrategy;

import java.util.ArrayList;

public class MergeSort extends SortStrategy {
    private void merge(ArrayList<Object> arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList<Object> L = new ArrayList<>();
        ArrayList<Object> R = new ArrayList<>();

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L.add(arr.get(l+i));
        for (int j = 0; j < n2; ++j)
            R.add(arr.get(m+1+j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (!this.order.check(L.get(i), R.get(j))) {
                arr.set(k, L.get(i));
                i++;
            }
            else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private void sortArray(ArrayList<Object> arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sortArray(arr, l, m);
            sortArray(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    @Override
    public void sort(ArrayList<Object> array) throws ClassCastException {
        sortArray(array, 0, array.size() - 1);
    }
}
