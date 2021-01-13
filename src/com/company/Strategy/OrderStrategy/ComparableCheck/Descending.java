package com.company.Strategy.OrderStrategy.ComparableCheck;

import com.company.Strategy.OrderStrategy.OrderStrategy;

public class Descending extends OrderStrategy {
    @Override
    public <T extends Comparable<T>> Boolean checkComparable(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
