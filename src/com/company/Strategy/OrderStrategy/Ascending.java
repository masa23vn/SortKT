package com.company.Strategy.OrderStrategy;

public class Ascending extends OrderStrategy {
    @Override
    public <T extends Comparable<T>> Boolean check(T a, T b) {
        return a.compareTo(b) > 0;
    }
}
