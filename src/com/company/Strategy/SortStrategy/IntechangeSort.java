package com.company.Strategy.SortStrategy;

import java.util.ArrayList;

public class IntechangeSort extends SortStrategy {
    @Override
    public void sort(ArrayList<Object> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (this.order.check(array.get(i), array.get(j))) {
                    Object temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }
        }
    }
}
