package com.company.Strategy.SortStrategy.Strategy;

import com.company.Strategy.SortStrategy.Constant.Complexity;

import java.util.ArrayList;

public class MergeSort extends SortStrategy {
    public MergeSort() {
        this.infos.put("best", Complexity.NLOGN);
        this.infos.put("average", Complexity.NLOGN);
        this.infos.put("worst", Complexity.NLOGN);
        this.infos.put("space", Complexity.N);
        this.infos.put("stability", Complexity.STABLE);
    }

    private void merge(ArrayList<Object> arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        ArrayList<Object> L = new ArrayList<>();
        ArrayList<Object> R = new ArrayList<>();

        for (int i = 0; i < n1; ++i)
            L.add(arr.get(l+i));
        for (int j = 0; j < n2; ++j)
            R.add(arr.get(m+1+j));

        int i = 0, j = 0;

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

        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    private void sortArray(ArrayList<Object> arr, int l, int r)
    {
        if (l < r) {
            int m = (l + r) / 2;
            sortArray(arr, l, m);
            sortArray(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    @Override
    public void sort(ArrayList<Object> array) throws ClassCastException {
        sortArray(array, 0, array.size() - 1);
    }
}
